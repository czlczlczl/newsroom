(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[67],{C0na:function(e,a,t){"use strict";t.r(a);var n=t("d6i3"),r=t.n(n),c=t("77pt");a["default"]={namespace:"adminColumn",state:{typelist:[]},reducers:{updateState:function(e,a){var t=a.payload;return{typelist:t.typelist}}},effects:{queryCol:r.a.mark(function e(a,t){var n,s,u,l;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.callback,s=t.call,u=t.put,e.next=4,s(c["k"]);case 4:return l=e.sent,e.next=7,u({type:"updateState",payload:l});case 7:n(l);case 8:case"end":return e.stop()}},e)}),deleteOneCol:r.a.mark(function e(a,t){var n,s,u,l;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,s=a.callback,u=t.call,t.put,e.next=4,u(c["e"],n);case 4:l=e.sent,s(l);case 6:case"end":return e.stop()}},e)}),addCol:r.a.mark(function e(a,t){var n,s,u,l;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,s=a.callback,u=t.call,e.next=4,u(c["b"],n);case 4:l=e.sent,s(l);case 6:case"end":return e.stop()}},e)}),updateSec:r.a.mark(function e(a,t){var n,s,u,l;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,s=a.callback,u=t.call,e.next=4,u(c["p"],n);case 4:l=e.sent,s(l);case 6:case"end":return e.stop()}},e)})}}}}]);