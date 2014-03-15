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
    
    function getPolititians(party, callback) {
        var politicians = [],
            append      = null, 
            request     = null,
            page        = 1,
            LIMIT       = 100;
        
        append = function (data) {
            var politicians_on_this_page = data.objects.map(function(el) {
                var person = el.Dataobject.data;
                return {
                    nazwisko: person['ludzie.nazwa'],
                    id: person.id
                };
            });
            console.log('Got '+politicians_on_this_page.length+' items.');
            
            politicians = politicians.concat(politicians_on_this_page);
            
            if(politicians_on_this_page.length == LIMIT) {
                page += 1;
                request();
            } else {
                callback(politicians);
            }
        }
        
        request = function () {
            _ajax('http://mojepanstwo.pl/dane/sejm_kluby/'+party+'.json?limit='+LIMIT+'&page='+page, append);
        }
        
        request();
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
                        what: glosowanie['sejm_glosowania.tytul'],
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
        getVotes: getVotes
    };
})();
