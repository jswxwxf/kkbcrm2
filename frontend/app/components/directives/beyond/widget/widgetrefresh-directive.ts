/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'widgetRefresh';

class WidgetRefreshDirective implements angular.IDirective {

  restrict = 'A';

  template = '<i class="fa fa-undo"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function () {
      //Refresh widget content
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(WidgetRefreshDirective);
}];