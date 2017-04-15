/* global JW_APP_NAME */

JW_APP_NAME.directive('soft-history-change', function ($parse) {
    return function (scope, element, attrs) {
        var url = $parse(attrs.softHistoryChange);
        var title = $parse(attrs.docTitle);
        var data = $parse(attrs.historyData);

        scope.changeHistory = function (urlPath, title, data) {
            var currentUrl = location.protocol + '//' + location.host + location.pathname;
            currentUrl = currentUrl + "?" + urlPath;
            window.history.pushState(data, title === null ? null : title, currentUrl);
        };

        element.on('click', function (event) {
            scope.changeHistory(url, title, data);
        });
    };
});