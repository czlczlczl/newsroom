(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[65],{aASH:function(e,a,n){"use strict";n.r(a);var t=n("d6i3"),c=n.n(t),r=n("77pt");a["default"]={namespace:"adminAcademicSection",state:{pageBean:void 0,rows:void 0},reducers:{updatePageBean:function(e,a){var n=a.payload;if(1===n.result)return{pageBean:n.pageBean,rows:n.pageBean.rows}}},effects:{querySec:c.a.mark(function e(a,n){var t,s,p,u,o;return c.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.payload,s=a.callback,p=n.call,u=n.put,e.next=4,p(r["g"],t.page);case 4:return o=e.sent,e.next=7,u({type:"updatePageBean",payload:o});case 7:s(o);case 8:case"end":return e.stop()}},e)}),deleteOneSec:c.a.mark(function e(a,n){var t,s,p,u;return c.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.payload,s=a.callback,p=n.call,n.put,e.next=4,p(r["d"],t);case 4:u=e.sent,s(u);case 6:case"end":return e.stop()}},e)}),addSec:c.a.mark(function e(a,n){var t,s,p,u;return c.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.payload,s=a.callback,p=n.call,e.next=4,p(r["a"],t);case 4:u=e.sent,s(u);case 6:case"end":return e.stop()}},e)}),updateSec:c.a.mark(function e(a,n){var t,s,p,u;return c.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.payload,s=a.callback,p=n.call,e.next=4,p(r["h"],t);case 4:u=e.sent,s(u);case 6:case"end":return e.stop()}},e)})}}}}]);