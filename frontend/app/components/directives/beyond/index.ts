/// <reference path="../../../../lib/app.d.ts" />

'use strict';

import sidebarMenuDirective = require('./sidebar/sidebarmenu-directive');

import fullscreenDirective = require('./header/fullscreen-directive');
import sidebarTogglerDirective = require('./header/sidebartoggler-directive');
import pageTitleDirective = require('./header/pagetitle-directive');
import headerTitleDirective = require('./header/headertitle-directive');
import refreshDirective = require('./header/refresh-directive');

import sidebarCollapseDirective = require('./navbar/sidebarcollapse-directive');
import settingDirective = require('./navbar/setting-directive');

import chatLinkDirective = require('./chatbar/chatlink-directive');
import pageChatbarDirective = require('./chatbar/pagechatbar-directive');

import loadingContainerDirective = require('./loading/loadingcontainer-directive')

import flotChartRealtimeDirective = require('./realtimechart/floatchartrealtime-directive');
import databoxFlotChartRealtimeDirective = require('./realtimechart/databoxflotchartrealtime-directive');

import skinChangerDirective = require('./skin/skinchanger-directive');

import widgetMaximizeDirective = require('./widget/widgetmaximize-directive');
import widgetCollapseDirective = require('./widget/widgetcollapse-directive');
import widgetExpandDirective = require('./widget/widgetexpand-directive');
import widgetDisposeDirective = require('./widget/widgetdispose-directive');
import widgetConfigDirective = require('./widget/widgetconfig-directive');
import widgetRefreshDirective = require('./widget/widgetrefresh-directive');

export var load = (app: angular.IModule) => {
  app.directive(sidebarMenuDirective.directiveName, sidebarMenuDirective.Directive)
    .directive(fullscreenDirective.directiveName, fullscreenDirective.Directive)
    .directive(sidebarTogglerDirective.directiveName, sidebarTogglerDirective.Directive)
    .directive(pageTitleDirective.directiveName, pageTitleDirective.Directive)
    .directive(headerTitleDirective.directiveName, headerTitleDirective.Directive)
    .directive(refreshDirective.directiveName, refreshDirective.Directive)
    .directive(sidebarCollapseDirective.directiveName, sidebarCollapseDirective.Directive)
    .directive(settingDirective.directiveName, settingDirective.Directive)
    .directive(chatLinkDirective.directiveName, chatLinkDirective.Directive)
    .directive(pageChatbarDirective.directiveName, pageChatbarDirective.Directive)
    .directive(loadingContainerDirective.directiveName, loadingContainerDirective.Directive)
    .directive(flotChartRealtimeDirective.directiveName, flotChartRealtimeDirective.Directive)
    .directive(databoxFlotChartRealtimeDirective.directiveName, databoxFlotChartRealtimeDirective.Directive)
    .directive(skinChangerDirective.directiveName, skinChangerDirective.Directive)
    .directive(widgetMaximizeDirective.directiveName, widgetMaximizeDirective.Directive)
    .directive(widgetCollapseDirective.directiveName, widgetCollapseDirective.Directive)
    .directive(widgetExpandDirective.directiveName, widgetExpandDirective.Directive)
    .directive(widgetDisposeDirective.directiveName, widgetDisposeDirective.Directive)
    .directive(widgetConfigDirective.directiveName, widgetConfigDirective.Directive)
    .directive(widgetRefreshDirective.directiveName, widgetRefreshDirective.Directive);
};