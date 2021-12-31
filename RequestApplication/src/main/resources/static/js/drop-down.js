$(function() {
  var SecondprefOption = '';
  var prefOption = '',
    value,
	Secondvalue,
    prefdata,
	Secondprefdata,
    prefLength = pref.length;
	SecondprefLength = pref.length;
	$('#Forst_Choice_Ctiy_item').hide();/* 「#Forst_Choice_Ctiy_item」を隠す */
	$('#Second_Choice_Pretecture_item').hide();
 	$('#Forst_Choice_Ctiy').hide();
	$('#Second_Choice_Ctiy_item').hide();
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
	　$('#Forst_Choice_Ctiy_item').fadeIn();
    } else {
      $('#Forst_Choice_Ctiy').html('<option value="">市区町村で絞り込む</option>').fadeOut();
	　$('#Forst_Choice_Ctiy_item').fadeOut()
    }
  });
$('#Forst_Choice_Ctiy').on('change', function() {
    var selected = $(this).val()
	if (selected !== '') {
	for (var i = 0; i < SecondprefLength; i++) {
    Secondprefdata = pref[i]
    Secondvalue = Secondprefdata[0];
    if (Secondvalue == '都道府県を選択してください') {
      SecondprefOption += '<option value="" selected>' + Secondvalue + '</option>\n';
    } else {
      SecondprefOption += '<option value="' + Secondvalue + '">' + Secondvalue + '</option>\n';
    }
    $('#Second_Choice_Pretecture').html(SecondprefOption);
	$('#Second_Choice_Pretecture_item').fadeIn();
  }
} else {
	$('#Second_Choice_Pretecture_item').fadeOut()
	
}
});
  $('#Second_Choice_Pretecture').on('change', function() {
    var index = $(this).prop('selectedIndex');
    var selected = $(this).val();
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
      $('#Second_Choice_Ctiy').html(cityOption).fadeIn();
	　$('#Second_Choice_Ctiy_item').fadeIn();
    } else {
      $('#Second_Choice_Ctiy').html('<option value="">市区町村で絞り込む</option>').fadeOut();
	　$('#Second_Choice_Ctiy_item').fadeOut()
    }
  });
});