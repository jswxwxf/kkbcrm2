/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'headerTitle';

class HeaderTitleDirective implements angular.IDirective {

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
      var description = '';
      if (toState.ncyBreadcrumb && toState.ncyBreadcrumb.label) title = toState.ncyBreadcrumb.label;
      if (toState.ncyBreadcrumb && toState.ncyBreadcrumb.description) description = toState.ncyBreadcrumb.description;
      this.$timeout(() => {
        if(description == '')
          el.text(title);
        else
          el.html(title + ' <small> <i class="fa fa-angle-right"> </i> '+ description + ' </small>');
      }, 0, false);
    };
    this.$rootScope.$on('$stateChangeSuccess', listener);

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(HeaderTitleDirective);
}];