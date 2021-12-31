$(function() {
  var prefOption = '',
    value,
    prefdata,
    prefLength = pref.length;
	$('#Forst_Choice_Ctiy_item').hide();/* 「#Forst_Choice_Ctiy_item」を隠す */
  $('#Forst_Choice_Ctiy').hide();
  for (var i = 0; i < prefLength; i++) {
    prefdata = pref[i]
    value = prefdata[0];
    if (value == '都道府県を選択してください') {
      prefOption += '<option value="" selected>' + value + '</option>\n';
    } else {
      prefOption += '<option value="' + value + '">' + value + '</option>\n';
    }
    $('#Forst_Choice_Pretecture').html(prefOption);
  }

  $('#Forst_Choice_Pretecture').on('change', function() {
    var index = $(this).prop('selectedIndex');
    var selected = $(this).val();
	$('#Forst_Choice_Ctiy_item').fadeIn();
    if (selected !== '') {
      var cityOption = '';
      $.each(pref[index][1], function() {
        if (this == '市区町村で絞り込む') {
          cityOption += '<option value="">' + this + '</option>\n';
          console.log(this);
        } else {
          cityOption += '<option value="' + this + '">' + this + '</option>\n';
          console.log(this);
        }
      });
      $('#Forst_Choice_Ctiy').html(cityOption).fadeIn();
    } else {
      $('#Forst_Choice_Ctiy').html('<option value="">市区町村で絞り込む</option>').fadeOut();
    }
  });
});