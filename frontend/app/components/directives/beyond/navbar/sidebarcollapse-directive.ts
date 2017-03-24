/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'sidebarCollapse';

class SidebarCollapseDirective implements angular.IDirective {

  restrict = 'AC';

  template = '<i class="collapse-icon fa fa-bars"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function () {
      if (!$('#sidebar').is(':visible'))
        $("#sidebar").toggleClass("hide");
      $("#sidebar").toggleClass("menu-compact");
      $(".sidebar-collapse").toggleClass("active");
      var isCompact = $("#sidebar").hasClass("menu-compact");

      if ($(".sidebar-menu").closest("div").hasClass("slimScrollDiv")) {
        $(".sidebar-menu")['slimScroll']({ destroy: true });
        $(".sidebar-menu").attr('style', '');
      }
      if (isCompact) {
        $(".open > .submenu")
          .removeClass("open");
      } else {
        //if ($('.page-sidebar').hasClass('sidebar-fixed')) {
        //  var position = 'left';
        //  $('.sidebar-menu')['slimscroll']({
        //    height: $(window).height() - 90,
        //    position: position,
        //    size: '3px',
        //    color: window['themeprimary']
        //  });
        //}
      }
      //Slim Scroll Handle
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(SidebarCollapseDirective);
}];