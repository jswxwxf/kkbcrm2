/// <reference path="../../../lib/app.d.ts" />

'use strict';

//import weekPaginatorDirective = require('./week-paginator/week-paginator-directive');
//import companySelectorDirective = require('./company-selector/company-selector-directive');
//import packageSelectorDirective = require('./package-selector/package-selector-directive');
//import packageViewerDirective = require('./package-viewer/package-viewer-directive');
//import carSelectorDirective = require('./region-selector/region-selector-directive');
//import countDownDirective = require('./count-down/count-down-directive');
//import lcbRadioDirective = require('./radio/lcb-radio-directive');
//import stepIndicatorDirective = require('./step-indicator/step-indicator-directive');
//import lcbValidatorDirective = require('./validator/lcb-validator-directive')
//import carSwitcherDirective = require('./region-switcher/region-switcher-directive')
//import lcbFileUploaderDirective = require('./file-uploader/lcb-file-uploader-directive')
//import lcbDisableByDirective = require('./disable-by/lcb-disable-by-directive')
//import orderCardDirective = require('./order-card/order-card-directive');
//import ticketCardDirective = require('./ticket-card/ticket-card-directive')
//import scoreBarDirective = require('./score-bar/score-bar-directive');
//import chartsDirective = require('./charts/charts-directive');
//import registerDirective = require('./register/register-directive');

import beyondDirectives = require('./beyond/index');

export var load = (app: angular.IModule) => {
  beyondDirectives.load(app);
  //app.directive(weekPaginatorDirective.directiveName, weekPaginatorDirective.Directive)
  //  .directive(companySelectorDirective.directiveName, companySelectorDirective.Directive)
  //  .directive(packageSelectorDirective.directiveName, packageSelectorDirective.Directive)
  //  .directive(packageViewerDirective.directiveName, packageViewerDirective.Directive)
  //  .directive(carSelectorDirective.directiveName, carSelectorDirective.Directive)
  //  .directive(countDownDirective.directiveName, countDownDirective.Directive)
  //  .directive(lcbRadioDirective.directiveName, lcbRadioDirective.Directive)
  //  .directive(stepIndicatorDirective.directiveName, stepIndicatorDirective.Directive)
  //  .directive(lcbValidatorDirective.directiveName, lcbValidatorDirective.Directive)
  //  .directive(carSwitcherDirective.directiveName, carSwitcherDirective.Directive)
  //  .directive(lcbFileUploaderDirective.directiveName, lcbFileUploaderDirective.Directive)
  //  .directive(lcbDisableByDirective.directiveName, lcbDisableByDirective.Directive)
  //  .directive(orderCardDirective.directiveName, orderCardDirective.Directive)
  //  .directive(ticketCardDirective.directiveName, ticketCardDirective.Directive)
  //  .directive(scoreBarDirective.directiveName, scoreBarDirective.Directive)
  //  .directive(chartsDirective.directiveName, chartsDirective.Directive)
  //  .directive(registerDirective.directiveName, registerDirective.Directive);
};