(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[19],{oQCN:function(e,t,r){"use strict";r.r(t);r("IzEo");var a,i,n,l=r("bx4M"),c=r("2Taf"),s=r.n(c),p=r("vZ4D"),o=r.n(p),m=r("l4Ni"),u=r.n(m),h=r("ujKo"),d=r.n(h),f=r("MhPg"),D=r.n(f),E=r("q1tI"),g=r.n(E),y=r("MuoO"),v=r("+kNj"),S=r("zHco"),w="adminRefereeDetail",b="academicSection",k=function(e){var t=e[w].data,r=e[w].loading,a=e[b].list;return{academicSec:a,refereeDetail:t,loading:r}},z=(a=Object(y["connect"])(k,null),a((n=function(e){function t(){var e,r;s()(this,t);for(var a=arguments.length,i=new Array(a),n=0;n<a;n++)i[n]=arguments[n];return r=u()(this,(e=d()(t)).call.apply(e,[this].concat(i))),r.translateAcademicSec=function(e){if(!r.props.academicSec)return null;for(var t=0;t<r.props.academicSec.length;t++)if(r.props.academicSec[t].id==e)return r.props.academicSec[t].academicsec;return null},r}return D()(t,e),o()(t,[{key:"componentDidMount",value:function(){var e={username:this.props.match.params.username};this.props.dispatch({type:"".concat(w,"/queryRefereeDetail"),payload:e}),this.props.dispatch({type:"".concat(b,"/queryList")})}},{key:"render",value:function(){var e=v["a"].Description;return g.a.createElement(S["a"],{title:"\u5ba1\u7a3f\u4eba\u4fe1\u606f",loading:this.props.loading},g.a.createElement(l["a"],{bordered:!1},g.a.createElement(v["a"],{size:"large",title:"\u57fa\u7840\u4fe1\u606f",style:{marginBottom:32}},g.a.createElement(e,{term:"\u5185\u90e8ID"},this.props.refereeDetail?this.props.refereeDetail.id:null),g.a.createElement(e,{term:"\u7528\u6237\u540d"},this.props.refereeDetail?this.props.refereeDetail.username:null),g.a.createElement(e,{term:"\u59d3\u540d"},this.props.refereeDetail?this.props.refereeDetail.name:null),g.a.createElement(e,{term:"\u6027\u522b"},this.props.refereeDetail?1===this.props.refereeDetail.gender?"\u7537":"\u5973":null)),g.a.createElement(v["a"],{size:"large",title:"\u5b66\u672f\u4fe1\u606f",style:{marginBottom:32}},g.a.createElement(e,{term:"\u5b66\u672f\u5206\u533a1"},this.props.refereeDetail?this.translateAcademicSec(this.props.refereeDetail.academicsec1):null),g.a.createElement(e,{term:"\u5b66\u672f\u5206\u533a2"},this.props.refereeDetail?this.props.refereeDetail.academicsec2?this.translateAcademicSec(this.props.refereeDetail.academicsec2):"\u65e0":null),g.a.createElement(e,{term:"\u5b66\u672f\u5206\u533a3"},this.props.refereeDetail?this.props.refereeDetail.academicsec3?this.translateAcademicSec(this.props.refereeDetail.academicsec3):"\u65e0":null)),g.a.createElement(v["a"],{size:"large",title:"\u94f6\u884c\u5361\u4fe1\u606f",style:{marginBottom:32}},g.a.createElement(e,{term:"\u94f6\u884c\u5361\u53f7"},this.props.refereeDetail?this.props.refereeDetail.card:null),g.a.createElement(e,{term:"\u5f00\u6237\u884c"},this.props.refereeDetail?this.props.refereeDetail.bank:null))))}}]),t}(g.a.Component),i=n))||i);t["default"]=z}}]);