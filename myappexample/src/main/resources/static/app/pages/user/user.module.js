(function () {
  'use strict';

  angular.module('BlurAdmin.pages.user',[])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('user', {
          url: '/user',
          templateUrl: 'app/pages/user/user.html',
          controller: 'UserCtrl',
          controllerAs: 'vm',
          title: 'Cadastro de Clientes',
          sidebarMeta: {
          	icon: 'ion-android-home',
            order: 0,
          },
        });
  }

})();



