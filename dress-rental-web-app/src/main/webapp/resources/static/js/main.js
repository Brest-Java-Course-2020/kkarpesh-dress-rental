 $('#editDressModal').on('show.bs.modal', function(e) {
        var name = $(e.relatedTarget).data('name');
        var id = $(e.relatedTarget).data('id');

        $(e.currentTarget).find('input[name="dressName"]').val(name);
        $(e.currentTarget).find('input[name="dressId"]').val(id);
 });

 $('#deleteDressModal').on('show.bs.modal', function(e) {
        var name = $(e.relatedTarget).data('name');
        var id = $(e.relatedTarget).data('id');

        $(e.currentTarget).find('.modal-body').text('Are you sure you want to remove the dress "' + name + '"?');
        document.getElementById('deleteDressUrl').href = '/dresses/delete/' + id;

  });

   $('#editRentModal').on('show.bs.modal', function(e) {
          var rentId = $(e.relatedTarget).data('id');
          var client = $(e.relatedTarget).data('client');
          var date = $(e.relatedTarget).data('date');
          var dress = $(e.relatedTarget).data('dress');

          $(e.currentTarget).find('input[name="client"]').val(client);
          $(e.currentTarget).find('input[name="rentId"]').val(rentId);
          $(e.currentTarget).find('input[name="rentDate"]').val(date);
   });

    $('#deleteRentModal').on('show.bs.modal', function(e) {
             var rentId = $(e.relatedTarget).data('id');
             var client = $(e.relatedTarget).data('client');
             var date = $(e.relatedTarget).data('date');
             var dressname = $(e.relatedTarget).data('dressname');

              $(e.currentTarget).find('.modal-body').text('Are you sure you want to remove the dress "' + dressname + '" rented by ' + client + ' on ' + date + '?');
              document.getElementById('deleteRentUrl').href = '/rents/delete/' + rentId;
      });