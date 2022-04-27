$(function() {
  var SecondprefOption = '';
  var prefOption = '',
    value,
	Secondvalue,
    prefdata,
	Secondprefdata,
	priceOption = '',
	pricedata,
	pricevalue,
	priceLength = price.length; /* priceの配列要素数を取得*/
    prefLength = pref.length; /*prefの配列要素数を取得*/
	SecondprefLength = pref.length;
	$('#Forst_Choice_Ctiy_item').hide();/* 「#Forst_Choice_Ctiy_item」を隠す */
	$('#Second_Choice_Pretecture_item').hide();
 	$('#Forst_Choice_Ctiy').hide();
	$('#Second_Choice_Ctiy_item').hide();
	$('#Third_Choice_Pretecture_item').hide();
	$('#Third_Choice_Ctiy_item').hide();
	$('#Asking_price_max_item').hide();
	
	/* iがprefLengthの配列要素数が少ない場合はiに1を追加しながら処理を繰り返す*/
  for (var i = 0; i < prefLength; i++) {
    prefdata = pref[i]/*prefdataにprefにiの数の要素を代入 */
    value = prefdata[0];/*valueにprefdata[0]の要素を代入*/
    if (value == '都道府県を選択してください') {
	/*optionでドロップダウン化してselecedで選択状態*/ 
      prefOption += '<option value="" selected>' + value + '</option>\n';
    } else {
      prefOption += '<option value="' + value + '">' + value + '</option>\n';
    }
    $('#Forst_Choice_Pretecture').html(prefOption);
  }
  /**第一希望の市町村入力フォーム表示 */
	for (var p = 0; p < priceLength; p++) {
		pricedata = price[p]/*pricedataにpriceにpの数の要素を代入 */
		pricevalue = pricedata[0];/*valueにprefdata[0]の要素を代入*/
	if (pricevalue == '希望最小価格を選択してください') {
		 priceOption += '<option value="" selected>' + pricevalue + '</option>\n';
	} else {
		 priceOption += '<option value="' + pricevalue + '">' + pricevalue + '</option>\n';
	 }
	 $('#Asking_price_min').html(priceOption)
  }
	 $('#Asking_price_min').on('change', function() {
    var priceindex = $(this).prop('selectedIndex');
    var priceselected = $(this).val();
    if (priceselected !== '') {
      var priceOption = '';
      $.each(price[priceindex][1], function() {
        if (this == '希望最大価格を選択してください') {
          priceOption += '<option value="">' + this + '</option>\n';
          console.log(this);
        } else {
          priceOption += '<option value="' + this + '">' + this + '</option>\n';
          console.log(this);
        }
      });
      $('#Asking_price_max').html(priceOption).fadeIn();
	　$('#Asking_price_max_item').fadeIn();
    } else {
      $('#Asking_price_max').html('<option value="">希望最大価格を選択してください</option>').fadeOut();
	　$('#Asking_price_max_item').fadeOut();
    }
  });

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
	　$('#Forst_Choice_Ctiy_item').fadeOut();
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
	$('#Second_Choice_Pretecture_item').fadeOut();
	
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
	　$('#Second_Choice_Ctiy_item').fadeOut();
    }
  });
$('#Second_Choice_Ctiy').on('change', function() {
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
    $('#Third_Choice_Pretecture').html(SecondprefOption);
	$('#Third_Choice_Pretecture_item').fadeIn();
  }
} else {
	$('#Third_Choice_Pretecture_item').fadeOut();
	
}
});
  $('#Third_Choice_Pretecture').on('change', function() {
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
      $('#Third_Choice_Ctiy').html(cityOption).fadeIn();
	　$('#Third_Choice_Ctiy_item').fadeIn();
    } else {
      $('#Third_Choice_Ctiy').html('<option value="">市区町村で絞り込む</option>').fadeOut();
	　$('#Third_Choice_Ctiy_item').fadeOut();
    }
  });
});