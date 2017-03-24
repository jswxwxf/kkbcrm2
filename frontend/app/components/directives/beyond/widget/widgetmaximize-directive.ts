/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'widgetMaximize';

class WidgetMaximizeDirective implements angular.IDirective {

  restrict = 'A';

  template = '<i class="fa fa-expand"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function () {
      var widget = el.parents(".widget").eq(0);
      var button = el.find("i").eq(0);
      var compress = "fa-compress";
      var expand = "fa-expand";
      if (widget.hasClass("maximized")) {
        if (button) {
          button.addClass(expand).removeClass(compress);
        }
        widget.removeClass("maximized");
        widget.find(".widget-body").css("height", "auto");
      } else {
        if (button) {
          button.addClass(compress).removeClass(expand);
        }
        widget.addClass("maximized");
        if (widget) {
          var windowHeight = $(window).height();
          var headerHeight = widget.find(".widget-header").height();
          widget.find(".widget-body").height(windowHeight - headerHeight);
        }
      }
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(WidgetMaximizeDirective);
}];