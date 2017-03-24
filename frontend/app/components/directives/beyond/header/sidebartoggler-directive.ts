/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'sidebarToggler';

class SidebarTogglerDirective implements angular.IDirective {

  restrict = 'AC';

  template = '<i class="fa fa-arrows-h"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function() {
      $("#sidebar").toggleClass("hide");
      el.toggleClass("active");
      return false;
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(SidebarTogglerDirective);
}];