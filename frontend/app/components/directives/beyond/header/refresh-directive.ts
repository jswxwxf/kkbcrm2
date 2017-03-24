/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'refresh';

class RefreshDirective implements angular.IDirective {

  restrict = 'AC';

  template = '<i class="glyphicon glyphicon-refresh"></i>';

  static $inject = ['$rootScope', '$state', '$stateParams'];

  constructor(private $rootScope, private $state, private $stateParams) {}

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', () => {
      this.$state.transitionTo(this.$state.current, this.$stateParams, {
        reload: true,
        inherit: false,
        notify: true
      });
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(RefreshDirective);
}];