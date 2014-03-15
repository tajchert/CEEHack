var importer = (function() {
    function _ajax(url, callback) {
        $.ajax({
            url: url,
            type: 'GET',
            dataType: 'json',
            success: function(data, textStatus, xhr) { 
                callback(data);
            },
            error: function() { log.error('Request failed!'); }
        });
    };
    function _ajaxAccu(url, callback) {
        var accu        = [],
            _append     = null, 
            _request    = null,
            page        = 1,
            LIMIT       = 200;
        
        _append = function (data) {
            var part = data.objects;
            console.log('Got '+part.length+' items.');
            
            accu = accu.concat(part);
            
            if(part.length == LIMIT) {
                page += 1;
                _request();
            } else {
                callback(accu);
            }
        }
        
        _request = function () {
            _ajax(url+'?limit='+LIMIT+'&page='+page, _append);
        }
        
        _request();
    };
    
    function getPolititians(party, callback) {
        _ajaxAccu('http://mojepanstwo.pl/dane/sejm_kluby/'+party+'.json', 
                  function(data) {
                      callback(data.map(function(el) {
                          var person = el.Dataobject.data;
                          return {
                              nazwisko: person['ludzie.nazwa'],
                              id: person.id
                          };
                      }));
                  });
    };    
    
    function getVotings(callback) {
        _ajaxAccu('http://mojepanstwo.pl/dane/sejm_glosowania.json', 
                  function(data) {
                      callback(data.map(function(el) {
                          var voting = el.Dataobject.data;
                          return {
                              tytul: voting.tytul,
                              id:    voting.id
                          };
                      }));
                  });
    };    
    
    function getPartyVotes(party, voting, callback) {
        _ajax('http://mojepanstwo.pl/dane/sejm_glosowania/'+voting+'.json', 
              function (data) {
                  var all_votes   = data._layers.wynikiKlubowe, 
                      party_votes = all_votes.filter(function (element) {
                                      return ""+element.klub_id == party;
                                  })[0];
                  
                  callback({
                      total:     party_votes.l, 
                      absent:    party_votes.n,
                      abstended: party_votes.w,
                      "for":     party_votes.z,
                      against:   party_votes.p
                  });
              });
    };
    
    function getVotes(person, callback) {
        var vote_name = {
            1: 'voted for',
            2: 'voted against',
            3: 'abstended',
            4: 'absent'
        };
    
        _ajax('http://mojepanstwo.pl/dane/poslowie/'+person+'/glosowania.json?page=1&limit=10',
            function(data) { 
                var votes = data.objects.map(function (obj) {
                    var glosowanie = obj.Dataobject.data;
                    return {
                        what: glosowanie['sejm_glosowania.id'],
                        how:  vote_name[glosowanie['glos_id']]
                    };
                });
                
                if(typeof callback === 'function') {
                    callback(votes);
                }
            });
    };
    
    return {
        getPolititians: getPolititians,
        getVotes: getVotes,
        getVotings: getVotings,
        getPartyVotes: getPartyVotes
    };
})();

//importer.getPolititians(1, function (politicians){console.log('politicians', politicians)});
//importer.getVotes(406, function (votes) { console.log(votes.map(function(el){return el.how})); });
//importer.getVotings(function (votings) { console.log('votings', votings); });
importer.getPartyVotes(1, 4364, function (votes) { console.log('party votes', votes); });
