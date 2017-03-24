/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'sidebarMenu';

class SidebarMenuDirective implements angular.IDirective {

  restrict = 'AC';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    setTimeout(() => {
      el.find('li.active').parents('li').addClass('active open');
    }, 0);

    el.on('click', 'a', function (e) {
      e.preventDefault();
      var isCompact = $("#sidebar").hasClass("menu-compact");
      var menuLink = $(e.target);
      if ($(e.target).is('span'))
        menuLink = $(e.target).closest('a');
      if (!menuLink || menuLink.length == 0)
        return;
      if (!menuLink.hasClass("menu-dropdown")) {
        if (isCompact && menuLink.get(0).parentNode.parentNode == this) {
          var menuText = menuLink.find(".menu-text").get(0);
          if (e.target != menuText && !$.contains(menuText, e.target)) {
            return false;
          }
        }
        return;
      }
      var submenu = menuLink.next().get(0);
      if (!$(submenu).is(":visible")) {
        var c = $(submenu.parentNode).closest("ul");
        if (isCompact && c.hasClass("sidebar-menu"))
          return;
        c.find("* > .open > .submenu")
          .each(function() {
            if (this != submenu && !$(this.parentNode).hasClass("active"))
              $(this).slideUp(200).parent().removeClass("open");
          });
      }
      if (isCompact && $(submenu.parentNode.parentNode).hasClass("sidebar-menu"))
        return false;
      $(submenu).slideToggle(200).parent().toggleClass("open");
      return false;
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(SidebarMenuDirective);
}];