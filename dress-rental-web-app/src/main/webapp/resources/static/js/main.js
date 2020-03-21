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