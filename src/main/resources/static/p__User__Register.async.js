(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[80],{GG8e:function(e,t,a){"use strict";a.r(t);a("IzEo");var r=a("bx4M"),n=(a("FJo9"),a("L41K")),s=a("2Taf"),c=a.n(s),i=a("vZ4D"),p=a.n(i),u=a("l4Ni"),l=a.n(u),o=a("ujKo"),d=a.n(o),h=a("MhPg"),m=a.n(h),g=a("q1tI"),f=a.n(g),E=a("h0LN"),S=a.n(E),w=function(e){function t(){return c()(this,t),l()(this,d()(t).apply(this,arguments))}return m()(t,e),p()(t,[{key:"getCurrentStep",value:function(){var e=this.props.location,t=e.pathname,a=t.split("/");switch(a[a.length-1]){case"info":return 0;case"address":return 1;case"education":return 2;case"academic":return 3;case"safequestions":return 4;case"result":return 5;default:return 0}}},{key:"render",value:function(){return f.a.createElement(r["a"],{bordered:!1,className:S.a.Card},f.a.createElement(g["Fragment"],null,f.a.createElement(n["a"],{current:this.getCurrentStep(),className:S.a.steps},f.a.createElement(n["a"].Step,{title:"\u57fa\u7840\u4fe1\u606f"}),f.a.createElement(n["a"].Step,{title:"\u5730\u5740\u4fe1\u606f"}),f.a.createElement(n["a"].Step,{title:"\u6559\u80b2\u4fe1\u606f"}),f.a.createElement(n["a"].Step,{title:"\u5b66\u672f\u8303\u56f4"}),f.a.createElement(n["a"].Step,{title:"\u5b89\u5168\u95ee\u9898"}),f.a.createElement(n["a"].Step,{title:"\u6210\u529f"})),this.props.children))}}]),t}(f.a.Component);t["default"]=w},h0LN:function(e,t,a){e.exports={steps:"antd-pro-pages-user-register-index-steps",Card:"antd-pro-pages-user-register-index-Card",captcha:"antd-pro-pages-user-register-index-captcha",captchaPic:"antd-pro-pages-user-register-index-captchaPic"}}}]);