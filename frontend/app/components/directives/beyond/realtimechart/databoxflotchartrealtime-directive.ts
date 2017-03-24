/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'databoxFlotChartRealtime';

class DataboxFlotChartRealtimeDirective implements angular.IDirective {

  restrict = "AE";

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: any, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    var data = [],
      totalPoints = 300,
      updateInterval = 100,
      plot,
      update,
      getRandomData;

    return getRandomData = function() {

      if (data.length > 0)
        data = data.slice(1);

      // Do a random walk

      while (data.length < totalPoints) {

        var prev = data.length > 0 ? data[data.length - 1] : 50,
          y = prev + Math.random() * 10 - 5;

        if (y < 0) {
          y = 0;
        } else if (y > 100) {
          y = 100;
        }

        data.push(y);
      }

      // Zip the generated y values with the x values

      var res = [];
      for (var i = 0; i < data.length; ++i) {
        res.push([i, data[i]]);
      }

      return res;
    },

      // Set up the control widget
      plot = $['plot'](el[0], [getRandomData()], {
        yaxis: {
          color: '#f3f3f3',
          min: 0,
          max: 100,
          tickFormatter: function(val, axis) {
            return "";
          }
        },
        xaxis: {
          color: '#f3f3f3',
          min: 0,
          max: 100,
          tickFormatter: function(val, axis) {
            return "";
          }
        },
        colors: ['#fff'],
        series: {
          lines: {
            lineWidth: 2,
            fill: false,
            fillColor: {
              colors: [
                {
                  opacity: 0.5
                }, {
                  opacity: 0
                }
              ]
            },
            steps: false
          },
          shadowSize: 0
        },
        grid: {
          show: false,
          hoverable: true,
          clickable: false,
          borderWidth: 0,
          aboveData: false
        }
      }), update = function() {

        plot.setData([getRandomData()]);
        plot.draw();
        setTimeout(update, updateInterval);

      },
      update();

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(DataboxFlotChartRealtimeDirective);
}];