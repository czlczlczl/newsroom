(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[96],{"7QD3":function(e,t,a){"use strict";a.r(t);var s=a("d6i3"),n=a.n(s),i=a("k9Yu");t["default"]={namespace:"isMailExist",state:{isExist:void 0},reducers:{updateState:function(e,t){var a=t.payload;return{isExist:a.result}}},effects:{queryIsExist:n.a.mark(function e(t,a){var s,r,c,u,p,l;return n.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return s=t.payload,r=t.callback,c=a.call,u=a.put,e.next=4,c(i["c"],s.email);case 4:return p=e.sent,e.next=7,u({type:"updateIsExist",payload:p});case 7:l={isExist:p.result},r(l);case 9:case"end":return e.stop()}},e)})}}}}]);