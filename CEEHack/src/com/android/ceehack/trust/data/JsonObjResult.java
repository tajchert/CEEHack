package com.android.ceehack.trust.data;

import com.google.gson.annotations.SerializedName;

public class JsonObjResult {

@SerializedName("brief")
private String brief;
@SerializedName("full")
private String full;
@SerializedName("status")
private String status;
@SerializedName("due_date")
private String due_date;

public String getBrief() {
return brief;
}

public void setBrief(String brief) {
this.brief = brief;
}

public String getFull() {
return full;
}

public void setFull(String full) {
this.full = full;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getDue_date() {
return due_date;
}

public void setDue_date(String due_date) {
this.due_date = due_date;
}

}