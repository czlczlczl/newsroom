(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[85],{"4Ofr":function(e,t,n){e.exports={themeColor:"antd-pro-components-setting-drawer-theme-color-themeColor",title:"antd-pro-components-setting-drawer-theme-color-title",colorBlock:"antd-pro-components-setting-drawer-theme-color-colorBlock"}},BFsb:function(e,t,n){e.exports={content:"antd-pro-components-setting-drawer-index-content",blockChecbox:"antd-pro-components-setting-drawer-index-blockChecbox",item:"antd-pro-components-setting-drawer-index-item",selectIcon:"antd-pro-components-setting-drawer-index-selectIcon",color_block:"antd-pro-components-setting-drawer-index-color_block",title:"antd-pro-components-setting-drawer-index-title",handle:"antd-pro-components-setting-drawer-index-handle",productionHint:"antd-pro-components-setting-drawer-index-productionHint"}},P5Jw:function(e,t,n){"use strict";var a=n("rHrb"),o=a.CopyToClipboard;o.CopyToClipboard=o,e.exports=o},PceP:function(e,t,n){"use strict";n.r(t);n("bbsP");var a=n("/wGt"),o=(n("fOrg"),n("+KLJ")),r=(n("+L6B"),n("2/Rp")),i=(n("miYZ"),n("tsqr")),c=(n("/zsF"),n("PArb")),l=(n("Pwec"),n("CtXQ")),s=(n("5Dmo"),n("3S7+")),p=(n("Mwp2"),n("VXEj")),u=(n("cIOH"),n("czTT"),n("q1tI")),d=n.n(u),f=n("17x9"),m=n("XIdC"),g=n.n(m),h=n("TSYQ"),y=n.n(h),b=n("BGR+"),v=n("g0mS"),w=n("wEI+");function k(e){return k="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"===typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},k(e)}function C(){return C=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var a in n)Object.prototype.hasOwnProperty.call(n,a)&&(e[a]=n[a])}return e},C.apply(this,arguments)}function E(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function O(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function j(e,t){for(var n=0;n<t.length;n++){var a=t[n];a.enumerable=a.enumerable||!1,a.configurable=!0,"value"in a&&(a.writable=!0),Object.defineProperty(e,a.key,a)}}function S(e,t,n){return t&&j(e.prototype,t),n&&j(e,n),e}function x(e,t){return!t||"object"!==k(t)&&"function"!==typeof t?M(e):t}function M(e){if(void 0===e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return e}function P(e){return P=Object.setPrototypeOf?Object.getPrototypeOf:function(e){return e.__proto__||Object.getPrototypeOf(e)},P(e)}function _(e,t){if("function"!==typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function");e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,writable:!0,configurable:!0}}),t&&N(e,t)}function N(e,t){return N=Object.setPrototypeOf||function(e,t){return e.__proto__=t,e},N(e,t)}var T=function(e){function t(){var e;return O(this,t),e=x(this,P(t).apply(this,arguments)),e.saveSwitch=function(t){e.rcSwitch=t},e.renderSwitch=function(t){var n,a=t.getPrefixCls,o=e.props,r=o.prefixCls,i=o.size,c=o.loading,s=o.className,p=void 0===s?"":s,d=o.disabled,f=a("switch",r),m=y()(p,(n={},E(n,"".concat(f,"-small"),"small"===i),E(n,"".concat(f,"-loading"),c),n)),h=c?u["createElement"](l["a"],{type:"loading",className:"".concat(f,"-loading-icon")}):null;return u["createElement"](v["a"],{insertExtraNode:!0},u["createElement"](g.a,C({},Object(b["default"])(e.props,["loading"]),{prefixCls:f,className:m,disabled:d||c,ref:e.saveSwitch,loadingIcon:h})))},e}return _(t,e),S(t,[{key:"focus",value:function(){this.rcSwitch.focus()}},{key:"blur",value:function(){this.rcSwitch.blur()}},{key:"render",value:function(){return u["createElement"](w["a"],null,this.renderSwitch)}}]),t}(u["Component"]);T.propTypes={prefixCls:f["string"],size:f["oneOf"](["small","default","large"]),className:f["string"]};var z,I,H,F=n("2Taf"),B=n.n(F),L=n("vZ4D"),A=n.n(L),R=n("l4Ni"),D=n.n(R),J=n("ujKo"),q=n.n(J),W=n("MhPg"),Y=n.n(W),Q=n("p0pE"),X=n.n(Q),Z=(n("OaEy"),n("2fM7")),K=n("Y2fQ"),G=n("P5Jw"),V=n("MuoO"),U=n("BFsb"),$=n.n(U),ee=n("jehZ"),te=n.n(ee),ne=n("Y/ft"),ae=n.n(ne),oe=n("4Ofr"),re=n.n(oe),ie=function(e){var t=e.color,n=e.check,a=ae()(e,["color","check"]);return d.a.createElement("div",te()({},a,{style:{backgroundColor:t}}),n?d.a.createElement(l["a"],{type:"check"}):"")},ce=function(e){var t=e.colors,n=e.title,a=e.value,o=e.onChange,r=t;return t||(r=[{key:"dust",color:"#F5222D"},{key:"volcano",color:"#FA541C"},{key:"sunset",color:"#FAAD14"},{key:"cyan",color:"#13C2C2"},{key:"green",color:"#52C41A"},{key:"daybreak",color:"#1890FF"},{key:"geekblue",color:"#2F54EB"},{key:"purple",color:"#722ED1"}]),d.a.createElement("div",{className:re.a.themeColor},d.a.createElement("h3",{className:re.a.title},n),d.a.createElement("div",{className:re.a.content},r.map(function(e){var t=e.key,n=e.color;return d.a.createElement(s["a"],{key:n,title:Object(K["formatMessage"])({id:"app.setting.themecolor.".concat(t)})},d.a.createElement(ie,{className:re.a.colorBlock,color:n,check:a===n,onClick:function(){return o&&o(n)}}))})))},le=ce,se=function(e){var t=e.value,n=e.onChange,a=e.list;return d.a.createElement("div",{className:$.a.blockChecbox,key:t},a.map(function(e){return d.a.createElement(s["a"],{title:e.title,key:e.key},d.a.createElement("div",{className:$.a.item,onClick:function(){return n(e.key)}},d.a.createElement("img",{src:e.url,alt:e.key}),d.a.createElement("div",{className:$.a.selectIcon,style:{display:t===e.key?"block":"none"}},d.a.createElement(l["a"],{type:"check"}))))}))},pe=se,ue=Z["a"].Option,de=function(e){var t=e.children,n=e.title,a=e.style;return d.a.createElement("div",{style:X()({},a,{marginBottom:24})},d.a.createElement("h3",{className:$.a.title},n),t)},fe=(z=Object(V["connect"])(function(e){var t=e.setting;return{setting:t}}),z((H=function(e){function t(){var e,n;B()(this,t);for(var a=arguments.length,o=new Array(a),r=0;r<a;r++)o[r]=arguments[r];return n=D()(this,(e=q()(t)).call.apply(e,[this].concat(o))),n.state={collapse:!1},n.getLayoutSetting=function(){var e=n.props.setting,t=e.contentWidth,a=e.fixedHeader,o=e.layout,r=e.autoHideHeader,i=e.fixSiderbar;return[{title:Object(K["formatMessage"])({id:"app.setting.content-width"}),action:d.a.createElement(Z["a"],{value:t,size:"small",onSelect:function(e){return n.changeSetting("contentWidth",e)},style:{width:80}},"sidemenu"===o?null:d.a.createElement(ue,{value:"Fixed"},Object(K["formatMessage"])({id:"app.setting.content-width.fixed"})),d.a.createElement(ue,{value:"Fluid"},Object(K["formatMessage"])({id:"app.setting.content-width.fluid"})))},{title:Object(K["formatMessage"])({id:"app.setting.fixedheader"}),action:d.a.createElement(T,{size:"small",checked:!!a,onChange:function(e){return n.changeSetting("fixedHeader",e)}})},{title:Object(K["formatMessage"])({id:"app.setting.hideheader"}),disabled:!a,disabledReason:Object(K["formatMessage"])({id:"app.setting.hideheader.hint"}),action:d.a.createElement(T,{size:"small",checked:!!r,onChange:function(e){return n.changeSetting("autoHideHeader",e)}})},{title:Object(K["formatMessage"])({id:"app.setting.fixedsidebar"}),disabled:"topmenu"===o,disabledReason:Object(K["formatMessage"])({id:"app.setting.fixedsidebar.hint"}),action:d.a.createElement(T,{size:"small",checked:!!i,onChange:function(e){return n.changeSetting("fixSiderbar",e)}})}]},n.changeSetting=function(e,t){var a=n.props.setting,o=X()({},a);o[e]=t,"layout"===e?o.contentWidth="topmenu"===t?"Fixed":"Fluid":"fixedHeader"!==e||t||(o.autoHideHeader=!1),n.setState(o,function(){var e=n.props.dispatch;e({type:"setting/changeSetting",payload:n.state})})},n.togglerContent=function(){var e=n.state.collapse;n.setState({collapse:!e})},n.renderLayoutSettingItem=function(e){var t=d.a.cloneElement(e.action,{disabled:e.disabled});return d.a.createElement(s["a"],{title:e.disabled?e.disabledReason:"",placement:"left"},d.a.createElement(p["a"].Item,{actions:[t]},d.a.createElement("span",{style:{opacity:e.disabled?"0.5":""}},e.title)))},n}return Y()(t,e),A()(t,[{key:"render",value:function(){var e=this,t=this.props.setting,n=t.navTheme,s=t.primaryColor,u=t.layout,f=t.colorWeak,m=this.state.collapse;return d.a.createElement(a["a"],{visible:m,width:300,onClose:this.togglerContent,placement:"right",handler:d.a.createElement("div",{className:$.a.handle,onClick:this.togglerContent},d.a.createElement(l["a"],{type:m?"close":"setting",style:{color:"#fff",fontSize:20}})),style:{zIndex:999}},d.a.createElement("div",{className:$.a.content},d.a.createElement(de,{title:Object(K["formatMessage"])({id:"app.setting.pagestyle"})},d.a.createElement(pe,{list:[{key:"dark",url:"https://gw.alipayobjects.com/zos/rmsportal/LCkqqYNmvBEbokSDscrm.svg",title:Object(K["formatMessage"])({id:"app.setting.pagestyle.dark"})},{key:"light",url:"https://gw.alipayobjects.com/zos/rmsportal/jpRkZQMyYRryryPNtyIC.svg",title:Object(K["formatMessage"])({id:"app.setting.pagestyle.light"})}],value:n,onChange:function(t){return e.changeSetting("navTheme",t)}})),d.a.createElement(le,{title:Object(K["formatMessage"])({id:"app.setting.themecolor"}),value:s,onChange:function(t){return e.changeSetting("primaryColor",t)}}),d.a.createElement(c["a"],null),d.a.createElement(de,{title:Object(K["formatMessage"])({id:"app.setting.navigationmode"})},d.a.createElement(pe,{list:[{key:"sidemenu",url:"https://gw.alipayobjects.com/zos/rmsportal/JopDzEhOqwOjeNTXkoje.svg",title:Object(K["formatMessage"])({id:"app.setting.sidemenu"})},{key:"topmenu",url:"https://gw.alipayobjects.com/zos/rmsportal/KDNDBbriJhLwuqMoxcAr.svg",title:Object(K["formatMessage"])({id:"app.setting.topmenu"})}],value:u,onChange:function(t){return e.changeSetting("layout",t)}})),d.a.createElement(p["a"],{split:!1,dataSource:this.getLayoutSetting(),renderItem:this.renderLayoutSettingItem}),d.a.createElement(c["a"],null),d.a.createElement(de,{title:Object(K["formatMessage"])({id:"app.setting.othersettings"})},d.a.createElement(p["a"],{split:!1,renderItem:this.renderLayoutSettingItem,dataSource:[{title:Object(K["formatMessage"])({id:"app.setting.weakmode"}),action:d.a.createElement(T,{size:"small",checked:!!f,onChange:function(t){return e.changeSetting("colorWeak",t)}})}]})),d.a.createElement(c["a"],null),d.a.createElement(G["CopyToClipboard"],{text:JSON.stringify(Object(b["default"])(t,["colorWeak"]),null,2),onCopy:function(){return i["a"].success(Object(K["formatMessage"])({id:"app.setting.copyinfo"}))}},d.a.createElement(r["a"],{block:!0,icon:"copy"},Object(K["formatMessage"])({id:"app.setting.copy"}))),d.a.createElement(o["a"],{type:"warning",className:$.a.productionHint,message:d.a.createElement("div",null,Object(K["formatMessage"])({id:"app.setting.production.hint"})," ",d.a.createElement("a",{href:"https://u.ant.design/pro-v2-default-settings",target:"_blank",rel:"noopener noreferrer"},"src/defaultSettings.js"))})))}}]),t}(u["Component"]),I=H))||I);t["default"]=fe},czTT:function(e,t,n){e.exports={"ant-switch":"ant-switch","ant-switch-inner":"ant-switch-inner","ant-switch-loading-icon":"ant-switch-loading-icon","ant-switch-loading":"ant-switch-loading","ant-switch-checked":"ant-switch-checked","ant-switch-small":"ant-switch-small","ant-switch-disabled":"ant-switch-disabled",AntSwitchSmallLoadingCircle:"AntSwitchSmallLoadingCircle"}},rHrb:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.CopyToClipboard=void 0;var a=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var a in n)Object.prototype.hasOwnProperty.call(n,a)&&(e[a]=n[a])}return e},o=function(){function e(e,t){for(var n=0;n<t.length;n++){var a=t[n];a.enumerable=a.enumerable||!1,a.configurable=!0,"value"in a&&(a.writable=!0),Object.defineProperty(e,a.key,a)}}return function(t,n,a){return n&&e(t.prototype,n),a&&e(t,a),t}}(),r=n("q1tI"),i=s(r),c=n("+QRC"),l=s(c);function s(e){return e&&e.__esModule?e:{default:e}}function p(e,t){var n={};for(var a in e)t.indexOf(a)>=0||Object.prototype.hasOwnProperty.call(e,a)&&(n[a]=e[a]);return n}function u(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function d(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!==typeof t&&"function"!==typeof t?e:t}function f(e,t){if("function"!==typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}var m=t.CopyToClipboard=function(e){function t(){var e,n,a,o;u(this,t);for(var r=arguments.length,c=Array(r),s=0;s<r;s++)c[s]=arguments[s];return a=d(this,(e=t.__proto__||Object.getPrototypeOf(t)).call.apply(e,[this].concat(c))),n=a,a.onClick=function(e){var t=a.props,n=t.text,o=t.onCopy,r=t.children,c=t.options,s=i.default.Children.only(r),p=(0,l.default)(n,c);o&&o(n,p),s&&s.props&&"function"===typeof s.props.onClick&&s.props.onClick(e)},o=n,d(a,o)}return f(t,e),o(t,[{key:"render",value:function(){var e=this.props,t=(e.text,e.onCopy,e.options,e.children),n=p(e,["text","onCopy","options","children"]),o=i.default.Children.only(t);return i.default.cloneElement(o,a({},n,{onClick:this.onClick}))}}]),t}(i.default.PureComponent);m.defaultProps={onCopy:void 0,options:void 0}}}]);