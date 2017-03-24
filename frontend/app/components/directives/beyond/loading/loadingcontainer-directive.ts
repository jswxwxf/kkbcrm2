/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'loadingContainer';

class LoadingContainerDirective implements angular.IDirective {

  restrict = 'AC';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.removeClass('app-loading');
    scope.$on('$stateChangeStart', function (event) {
      el.addClass('app-loading');
    });
    scope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState) {
      event.targetScope.$watch('$viewContentLoaded', function() {
        el.removeClass('app-loading ');
      });
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(LoadingContainerDirective);
}];