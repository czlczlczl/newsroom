(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[26],{SGzH:function(t,e,a){"use strict";a.r(e);a("IzEo");var r,o,s,i=a("bx4M"),n=a("2Taf"),l=a.n(n),c=a("vZ4D"),p=a.n(c),d=a("l4Ni"),g=a.n(d),u=a("ujKo"),f=a.n(u),v=a("MhPg"),k=a.n(v),h=a("q1tI"),b=a.n(h),m=a("MuoO"),w=a("usdK"),L=a("zHco"),E=a("CkN6"),S=a("zBpx"),_=a.n(S),x="editorTaskList",y="editorDetailPublicStorage",R=function(t){var e=t[x].total,a=t[x].task,r=t[x].article,o=t[x].invoice,s=t[x].loading;return{article:r,invoice:o,loading:s,task:a,total:e}},z=(r=Object(m["connect"])(R,null),r((s=function(t){function e(t){var a;return l()(this,e),a=g()(this,f()(e).call(this,t)),a.handleSelectRows=function(t){a.setState({selectedRows:t})},a.getIDLink=function(t){for(var e={},r={},o=0,s=0;s<a.props.article.length;s++)if(a.props.article[s].id==t.id_article){e=a.props.article[s];break}for(var i=0;i<a.props.invoice.length;i++)a.props.invoice[i].id_article==t.id_article&&(r=a.props.invoice[i],o++);var n=0;if(0==t.stat&&3==t.role&&0==t.flag&&(n=0),4==t.stat&&3==t.role&&0==t.flag&&0==o&&(n=2),6==t.stat&&3==t.role&&0==t.flag&&1==o&&(n=3),1!=t.stat||3!=t.role||0!=t.flag||t.content||(n=4),1==t.stat&&3==t.role&&0==t.flag&&t.content&&(n=6),7==t.stat&&3==t.role&&0==t.flag&&t.content&&(n=9),7!=t.stat||3!=t.role||0!=t.flag||t.content||(n=11),5==t.stat&&3==t.role&&0==t.flag&&t.content&&(n=12),4==t.stat&&3==t.role&&0==t.flag&&0!=o&&(n=14),6==t.stat&&3==t.role&&0==t.flag&&2==o&&(n=16),2==o)for(var l=0;l<a.props.invoice.length;l++)if(a.props.invoice[l].id_article==t.id_article&&2==a.props.invoice[l].type){r=a.props.invoice[l];break}var c={article:e,task:t,invoice:r,step:n};a.props.dispatch({type:"".concat(y,"/storePublic"),payload:c,callback:function(){w["a"].push("/editor/taskdetail/".concat(t.id_article))}})},a.getTitle=function(t){for(var e=0;e<a.props.article.length;e++)if(a.props.article[e].id==t.id_article)return a.props.article[e].title;return""},a.getStatus=function(t){for(var e=0,r=0;r<a.props.invoice.length;r++)a.props.invoice[r].id_article==t.id_article&&(a.props.invoice[r],e++);return 0==t.stat&&3==t.role&&0==t.flag?"\u5f85\u521d\u5ba1":4==t.stat&&3==t.role&&0==t.flag&&0==e?"\u5b89\u6392\u7f34\u8d39":6==t.stat&&3==t.role&&0==t.flag&&1==e?"\u5f85\u786e\u8ba4\u5ba1\u7a3f\u8d39\u7f34\u8d39\u60c5\u51b5":1!=t.stat||3!=t.role||0!=t.flag||t.content?1==t.stat&&3==t.role&&0==t.flag&&t.content?"\u786e\u8ba4\u5ba1\u7a3f\u610f\u89c1":7!=t.stat||3!=t.role||0!=t.flag||t.content?7==t.stat&&3==t.role&&0==t.flag&&t.content?"\u5f85\u786e\u5b9a\u4e8c\u6b21\u5ba1\u7a3f\u610f\u89c1":5==t.stat&&3==t.role&&0==t.flag?"\u5f85\u8fdb\u884c\u683c\u5f0f\u4fee\u6539":4==t.stat&&3==t.role&&0==t.flag&&0!=e?"\u786e\u5b9a\u7248\u9762\u8d39":6==t.stat&&3==t.role&&0==t.flag&&2==e?"\u5f85\u5ba1\u6838\u7248\u9762\u8d39":void 0:"\u91cd\u5ba1\u5f85\u786e\u8ba4":"\u5206\u914d\u5ba1\u7a3f\u4eba"},a.columns=[{title:"\u6807\u9898",render:function(t,e){return b.a.createElement("a",{onClick:function(){return a.getIDLink(e)}},a.getTitle(e))}},{title:"\u5f53\u524d\u72b6\u6001",render:function(t,e){return a.getStatus(e)}}],a.state={selectedRows:{}},a}return k()(e,t),p()(e,[{key:"componentDidMount",value:function(){this.props.dispatch({type:"".concat(x,"/queryList")})}},{key:"render",value:function(){var t={list:this.props.task};return b.a.createElement(L["a"],{title:"\u5f85\u5b8c\u6210\u4efb\u52a1",content:"\u60a8\u53ef\u4ee5\u5728\u6b64\u67e5\u9605\u60a8\u7684\u5f85\u5b8c\u6210\u4efb\u52a1"},b.a.createElement(i["a"],{bordered:!1},b.a.createElement("div",{className:_.a.text},"\u60a8\u5f53\u524d\u6709\xa0",b.a.createElement("b",null,this.props.task?this.props.task.length:"N/A"),"\xa0\u6761\u4efb\u52a1\u5f85\u5b8c\u6210\u3002")),b.a.createElement(i["a"],{bordered:!1},b.a.createElement("div",{className:_.a.tableList},b.a.createElement(E["a"],{pagination:{hideOnSinglePage:!0},selectedRows:this.state.selectedRows,loading:this.props.loading,data:t,columns:this.columns,onSelectRow:this.handleSelectRows}))))}}]),e}(b.a.Component),o=s))||o);e["default"]=z},zBpx:function(t,e,a){t.exports={tableList:"antd-pro-pages-editor-task-list-tableList",tableListOperator:"antd-pro-pages-editor-task-list-tableListOperator",text:"antd-pro-pages-editor-task-list-text",tableListForm:"antd-pro-pages-editor-task-list-tableListForm",submitButtons:"antd-pro-pages-editor-task-list-submitButtons",error:"antd-pro-pages-editor-task-list-error",success:"antd-pro-pages-editor-task-list-success",warning:"antd-pro-pages-editor-task-list-warning","progress-pass":"antd-pro-pages-editor-task-list-progress-pass",progress:"antd-pro-pages-editor-task-list-progress"}}}]);