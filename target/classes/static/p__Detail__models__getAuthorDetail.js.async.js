(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[20],{"195l":function(a,e,t){"use strict";t.r(e);var n=t("d6i3"),r=t.n(n),u=t("k9Yu");e["default"]={namespace:"adminAuthorDetail",state:{data:void 0},reducers:{updateData:function(a,e){var t=e.payload;if(1==t.result)return{data:t.pageBean.rows[0]}}},effects:{queryAuthorDetail:r.a.mark(function a(e,t){var n,s,p,o,c;return r.a.wrap(function(a){while(1)switch(a.prev=a.next){case 0:return n=e.payload,s=t.call,p=t.put,o={role:1,page:1,email:n.username},a.next=5,s(u["h"],o);case 5:return c=a.sent,a.next=8,p({type:"updateData",payload:c});case 8:case"end":return a.stop()}},a)})}}}}]);