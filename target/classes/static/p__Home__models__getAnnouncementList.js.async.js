(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[37],{mwnJ:function(e,t,n){"use strict";n.r(t);var a=n("d6i3"),s=n.n(a),r=n("Xv78");t["default"]={namespace:"landingAnnouncementList",state:{processResult:""},reducers:{updateList:function(e,t){var n=t.payload,a=n;return{processResult:a}}},effects:{queryList:s.a.mark(function e(t,n){var a,u,c,p;return s.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return a=t.payload,u=n.call,c=n.put,e.next=4,u(r["b"],a);case 4:return p=e.sent,e.next=7,c({type:"updateList",payload:p});case 7:case"end":return e.stop()}},e)})}}}}]);