(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[98],{AkN1:function(e,a,t){"use strict";t.r(a);var n=t("d6i3"),r=t.n(n),o=t("p0pE"),c=t.n(o),p=t("k9Yu");a["default"]={namespace:"registerStorage",state:{step:void 0,email:void 0,password:void 0,name:void 0,name_pinyin:void 0,gender:void 0,address:void 0,postcode:void 0,workspace_cn:void 0,workspace_en:void 0,major:void 0,education:void 0,title:void 0,officetel:void 0,phonenum:void 0,location:void 0,researchdir:void 0,academicsec1:void 0,academicsec2:void 0,academicsec3:void 0,introduction:void 0,safeque1:void 0,safeque2:void 0,safeque3:void 0,result:void 0},reducers:{resetState:function(e,a){a.payload;return c()({},e,{result:void 0})},updateStateStep1:function(e,a){var t=a.payload;return c()({},e,{email:t.email,password:t.password,name:t.name,name_pinyin:t.name_pinyin,gender:t.gender,phonenum:t.phonenum,introduction:t.introduction,step:1})},updateStateStep2:function(e,a){var t=a.payload;return c()({},e,{address:t.address,postcode:t.postcode,workspace_cn:t.workspace_cn,workspace_en:t.workspace_en,location:t.location,step:2})},updateStateStep3:function(e,a){var t=a.payload;return c()({},e,{major:t.major,education:t.education,title:t.title,officetel:t.officetel})},updateStateStep4:function(e,a){var t=a.payload;return c()({},e,{researchdir:t.researchdir,academicsec1:t.academicsec1,academicsec2:t.academicsec2,academicsec3:t.academicsec3})},updateStateStep5:function(e,a){var t=a.payload;return c()({},e,{safeque1:t.safeque1,safeque2:t.safeque2,safeque3:t.safeque3})},updateStateResult:function(e,a){var t=a.payload;return c()({},e,{result:t.result})}},effects:{step1:r.a.mark(function e(a,t){var n,o;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,o=t.put,e.next=4,o({type:"updateStateStep1",payload:n});case 4:case"end":return e.stop()}},e)}),step2:r.a.mark(function e(a,t){var n,o;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,o=t.put,e.next=4,o({type:"updateStateStep2",payload:n});case 4:case"end":return e.stop()}},e)}),step3:r.a.mark(function e(a,t){var n,o;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,o=t.put,e.next=4,o({type:"updateStateStep3",payload:n});case 4:case"end":return e.stop()}},e)}),step4:r.a.mark(function e(a,t){var n,o;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,o=t.put,e.next=4,o({type:"updateStateStep4",payload:n});case 4:case"end":return e.stop()}},e)}),step5:r.a.mark(function e(a,t){var n,o,c;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,o=a.callback,c=t.put,e.next=4,c({type:"updateStateStep5",payload:n});case 4:o();case 5:case"end":return e.stop()}},e)}),submitRegister:r.a.mark(function e(a,t){var n,o,c,i,s;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=a.payload,o=a.callback,c=t.call,i=t.put,e.next=4,c(p["l"],n);case 4:return s=e.sent,e.next=7,i({type:"updateStateResult",payload:s});case 7:o();case 8:case"end":return e.stop()}},e)})}}}}]);