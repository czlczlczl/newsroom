(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[60],{"977x":function(e,n,a){"use strict";a.r(n);var t=a("d6i3"),c=a.n(t),u=a("Xv78");n["default"]={namespace:"adminModifyAnnouncement",state:{announcement:void 0},reducers:{updatePageBean:function(e,n){var a=n.payload;if(1===a.result)return{announcement:a.announcement}}},effects:{queryAnnouncementList:c.a.mark(function e(n,a){var t,r,o,s,i;return c.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=n.payload,r=n.callback,o=a.call,s=a.put,e.next=4,o(u["a"],t.id);case 4:return i=e.sent,e.next=7,s({type:"updatePageBean",payload:i});case 7:r(i);case 8:case"end":return e.stop()}},e)})}}}}]);