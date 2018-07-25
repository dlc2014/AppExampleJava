(function () {
  'use strict';

  angular.module('BlurAdmin.pages.user')
      .controller('UserCtrl', UserCtrl);

  /** @ngInject */
  function UserCtrl($scope, $uibModal, $http) {
   var vm = this;
   
   //Função para abri modal usado para criação e edição de clientes
    $scope.showUserModal = function (page, size) {
    	
      $uibModal.open({
        animation: true,
        templateUrl: page,
        size: size,
        scope: $scope,
        resolve: {
          items: function () {
            return $scope.items;
          }
        }
      });
    };

    //Abre o modal para inserir um novo cliente
    $scope.showModalToCreateUser = function(){
    	
    	$scope.updateUserData = undefined;
    	$scope.showUserModal('app/pages/user/userModal.html', 'lg');
    }
   
    // Lista todos os clientes
    $scope.getAllUsers = function () {
        
  		$http({
      		method : 'GET',
              url: '/user/getAllUsers',
      	})
      	.success(
      		function(data) {
      			console.log("GET USERS SUCESSO",data)
      			$scope.listUsers = data;
  		
      	})
          .error(function(result) {
          	console.log("ERRO GET ALL USERS",result);
          });
      };
      $scope.getAllUsers();
      
      //Remove um cliente
      $scope.deleteUser = function (data) {
          
          if (confirm("Deseja deletar o cliente "+data.nome+" ?")) {
        	  $http({
          		method : 'POST',
                  url: '/user/deleteUser',
                  data: {data: data}
          	})
          	.success(
          		function(data) {
          			$scope.getAllUsers();
          	})
              .error(function(result) {
              	alert("Falha ao remover cliente!");
              });
        	} 
    		
        };
        
        //Exibe o modal para editar um cliente
        $scope.showModalToEditUser = function (data) {
            
            $scope.updateUserData = angular.copy(data);            
            $scope.showUserModal('app/pages/user/userModal.html', 'lg');
          };
          
      // Exibe o modal para realizar um asimulação    
      $scope.showModalToSimulate = function (data) {
          
          $scope.updateUserData = angular.copy(data);
          $scope.showUserModal('app/pages/user/userSimulateModal.html', 'md');
        };
  }
})();

