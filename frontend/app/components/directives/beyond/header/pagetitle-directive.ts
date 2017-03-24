/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'pageTitle';

class PageTitleDirective implements angular.IDirective {

  static $inject = ['$rootScope', '$timeout'];

  constructor(private $rootScope, private $timeout) {}

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    var listener = (event, toState) => {
      var title = 'Default Title';
      if (toState.ncyBreadcrumb && toState.ncyBreadcrumb.label) title = toState.ncyBreadcrumb.label;
      this.$timeout(function() {
        el.text(title);
      }, 0, false);
    };
    this.$rootScope.$on('$stateChangeSuccess', listener);

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(PageTitleDirective);
}];