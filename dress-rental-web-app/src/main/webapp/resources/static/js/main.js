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
   var rentDate = $(e.relatedTarget).data('date');
   var dressId = $(e.relatedTarget).data('dressid');

   $(e.currentTarget).find('input[name="rentId"]').val(rentId);
   $(e.currentTarget).find('option[value="' + dressId + '"]').attr('selected','selected');
   $(e.currentTarget).find('input[name="client"]').val(client);
   $(e.currentTarget).find('input[name="rentDate"]').val(rentDate);
 });

 $('#deleteRentModal').on('show.bs.modal', function(e) {
   var rentId = $(e.relatedTarget).data('id');
   var client = $(e.relatedTarget).data('client');
   var rentDate = $(e.relatedTarget).data('date');
   var dressName = $(e.relatedTarget).data('dressname');

   $(e.currentTarget).find('.modal-body').text('Are you sure you want to remove the dress "' + dressName + '" rented by ' + client + ' on ' + rentDate + '?');
   document.getElementById('deleteRentUrl').href = '/rents/delete/' + rentId;
 });