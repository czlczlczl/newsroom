(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[18],{"ZRv+":function(e,t,a){"use strict";a.r(t);var r,i,n=a("2Taf"),o=a.n(n),l=a("vZ4D"),s=a.n(l),p=a("l4Ni"),d=a.n(p),u=a("ujKo"),c=a.n(u),m=a("MhPg"),h=a.n(m),D=a("q1tI"),f=a.n(D),g=a("MuoO"),E=a("bmkC"),v=a("+kNj"),y=a("zHco"),k=(a("8gUf"),"adminEditorDetail"),w=function(e){var t=e[k].data,a=e[k].loading;return{editorDetail:t,loading:a}},b=(r=Object(g["connect"])(w,null),r(i=function(e){function t(){return o()(this,t),d()(this,c()(t).apply(this,arguments))}return h()(t,e),s()(t,[{key:"componentDidMount",value:function(){var e={username:this.props.match.params.username};this.props.dispatch({type:"".concat(k,"/queryEditorDetail"),payload:e})}},{key:"render",value:function(){var e=v["a"].Description;return f.a.createElement(y["a"],{title:"\u7f16\u8f91\u4fe1\u606f",loading:this.props.loading},f.a.createElement(E["Card"],{bordered:!1},f.a.createElement(v["a"],{size:"large",title:"\u57fa\u7840\u4fe1\u606f",style:{marginBottom:32}},f.a.createElement(e,{term:"\u5185\u90e8ID"},this.props.editorDetail?this.props.editorDetail.id:null),f.a.createElement(e,{term:"\u7528\u6237\u540d"},this.props.editorDetail?this.props.editorDetail.username:null),f.a.createElement(e,{term:"\u59d3\u540d"},this.props.editorDetail?this.props.editorDetail.name:null),f.a.createElement(e,{term:"\u6027\u522b"},this.props.editorDetail?1===this.props.editorDetail.gender?"\u7537":"\u5973":null))))}}]),t}(f.a.Component))||i);t["default"]=b}}]);