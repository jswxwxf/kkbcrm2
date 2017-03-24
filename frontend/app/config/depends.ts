/// <reference path="../../lib/app.d.ts" />

'use strict';

export var load = (app: angular.IModule) => {

  app.config(['$ocLazyLoadProvider', ($ocLazyLoadProvider) => {

    $ocLazyLoadProvider.config({
      debug: true,
      events: true,
      modules: [
        {
          name: 'datatables',
          files: [
            //'bower_components/datatables/media/css/jquery.dataTables.css',
            'vendor/jquery/datatable/dataTables.bootstrap.css',
            //'bower_components/angular-datatables/dist/plugins/bootstrap/datatables.bootstrap.css',
            'bower_components/datatables.net/js/jquery.dataTables.js',
            'bower_components/datatables.net-bs/js/dataTables.bootstrap.js',
            'bower_components/angular-datatables/dist/angular-datatables.js',
            'bower_components/angular-datatables/dist/plugins/bootstrap/angular-datatables.bootstrap.js',

            'bower_components/datatables.net-buttons-bs/css/buttons.bootstrap.css',
            'bower_components/datatables.net-buttons/js/dataTables.buttons.js',
            'bower_components/datatables.net-buttons-bs/js/buttons.bootstrap.js',
            'bower_components/datatables.net-buttons/js/buttons.print.js',
            'bower_components/datatables.net-buttons/js/buttons.colVis.js',
            'bower_components/datatables.net-buttons/js/buttons.html5.js',
            'bower_components/datatables.net-buttons/js/buttons.flash.js',
            'bower_components/angular-datatables/dist/plugins/buttons/angular-datatables.buttons.js',

            'bower_components/datatables.net-colreorder-bs/css/colReorder.bootstrap.css',
            'bower_components/datatables.net-colreorder/js/dataTables.colReorder.js',
            'bower_components/angular-datatables/dist/plugins/colreorder/angular-datatables.colreorder.js',

            'bower_components/datatables.net-responsive-bs/css/responsive.bootstrap.css',
            'bower_components/datatables.net-responsive-bs/js/responsive.bootstrap.js',
            'bower_components/datatables.net-responsive/js/dataTables.responsive.js'

          ]
        },
        {
          name: 'toaster',
          files: [
            'lib/modules/angularjs-toaster/toaster.css',
            'lib/modules/angularjs-toaster/toaster.js'
          ]
        },
        {
          name: 'ui.select',
          files: [
            'lib/modules/angular-ui-select/select.css',
            'lib/modules/angular-ui-select/select.js'
          ]
        },
        {
          name: 'ngTagsInput',
          files: [
            'lib/modules/ng-tags-input/ng-tags-input.js'
          ]
        },
        {
          name: 'daterangepicker',
          serie: true,
          files: [
            'lib/modules/angular-daterangepicker/moment.js',
            'lib/modules/angular-daterangepicker/daterangepicker.js',
            'lib/modules/angular-daterangepicker/angular-daterangepicker.js'
          ]
        },
        {
          name: 'vr.directives.slider',
          files: [
            'lib/modules/angular-slider/angular-slider.min.js'
          ]
        },
        {
          name: 'minicolors',
          files: [
            'lib/modules/angular-minicolors/jquery.minicolors.js',
            'lib/modules/angular-minicolors/angular-minicolors.js'
          ]
        },
        {
          name: 'textAngular',
          files: [
            'lib/modules/text-angular/textAngular-sanitize.min.js',
            'lib/modules/text-angular/textAngular-rangy.min.js',
            'lib/modules/text-angular/textAngular.min.js'
          ]
        },
        {
          name: 'ng-nestable',
          files: [
            'lib/modules/angular-nestable/jquery.nestable.js',
            'lib/modules/angular-nestable/angular-nestable.js'
          ]
        },
        {
          name: 'angularBootstrapNavTree',
          files: [
            'lib/modules/angular-bootstrap-nav-tree/abn_tree_directive.js'
          ]
        },
        {
          name: 'ui.calendar',
          files: [
            'lib/jquery/fullcalendar/jquery-ui.custom.min.js',
            'lib/jquery/fullcalendar/moment.min.js',
            'lib/jquery/fullcalendar/fullcalendar.js',
            'lib/modules/angular-ui-calendar/calendar.js'
          ]
        },
        {
          name: 'ngGrid',
          files: [
            'lib/modules/ng-grid/ng-grid.min.js',
            'lib/modules/ng-grid/ng-grid.css'
          ]
        },
        {
          name: 'dropzone',
          files: [
            'lib/modules/angular-dropzone/dropzone.min.js',
            'lib/modules/angular-dropzone/angular-dropzone.js'
          ]
        }
      ]
    });

  }]);

}