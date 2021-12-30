$(function() {
	
	$('#sample').hide();/* 「#sample」を隠す */
	$('.yokohamabox').hide();/* 「.yokohamabox」を隠す */
	$('.hokkaidobox').hide();/* 「.hokkaidobox」を隠す */
	$('.tokyobox').hide();/* 「.tokyobox」を隠す */

	$(window).scroll(function()/* windowがスクロールされたら以下の処理を実行する */ {
		$('#sample').each(function()/* .each()で、「#sample」が付いた要素1つずつに順番に処理 */{
			
		/* .scrollTop()で、スクロールした量を取得して、変数scrollに代入 */
		var scroll = $(window).scrollTop();
		
		/* .offset().topで、ページの最上部から「#sample」が付いた要素までの距離を取得して、変数positionに代入 */
		var position =  $(this).offset().top;
		
		/* .height()で、ウィンドウの高さを取得して、変数windowHeightに代入 */
		var windowHeight = $(window).height();
		
		/* スクロール量が、「ページ最上部から要素までの距離」-「ウィンドウの高さ」を超えた時 */
		if (scroll > position - windowHeight + 200){
			
			$('#sample').fadeIn(1500);/* 「#sample」を徐々に表示 */
			
			}else{
			
			$('#sample').fadeout(1500);
				
			
			}
			
		 });
	$('.yokohamabox').each(function()/* .each()で、「.yokohamabox」が付いた要素1つずつに順番に処理 */{
			
		/* .scrollTop()で、スクロールした量を取得して、変数scrollに代入 */
		var scroll = $(window).scrollTop();
		
		/* .offset().topで、ページの最上部から「.yokohamabox」が付いた要素までの距離を取得して、変数positionに代入 */
		var position =  $(this).offset().top;
		
		/* .height()で、ウィンドウの高さを取得して、変数windowHeightに代入 */
		var windowHeight = $(window).height();
		
		/* スクロール量が、「ページ最上部から要素までの距離」-「ウィンドウの高さ」を超えた時 */
		if (scroll > position - windowHeight + 1000){
			
			$('.yokohamabox').fadeIn(3000);/* 「.yokohamabox」を徐々に表示 */
			
			}else{
			
			$('.yokohamabox').fadeout(1500);
				
			
			}
		
			
		 });
			$('.hokkaidobox').each(function()/* .each()で、「.hokkaidobox」が付いた要素1つずつに順番に処理 */{
				
			/* .scrollTop()で、スクロールした量を取得して、変数scrollに代入 */
			var scroll = $(window).scrollTop();
			
			/* .offset().topで、ページの最上部から「.hokkaidobox」が付いた要素までの距離を取得して、変数positionに代入 */
			var position =  $(this).offset().top;
			
			/* .height()で、ウィンドウの高さを取得して、変数windowHeightに代入 */
			var windowHeight = $(window).height();
			
			/* スクロール量が、「ページ最上部から要素までの距離」-「ウィンドウの高さ」を超えた時 */
			if (scroll > position - windowHeight + 1100){
				
				$('.hokkaidobox').fadeIn(4000);/* 「.hokkaidobox」を徐々に表示 */
				
				}else{
				
				$('.hokkaidobox').fadeout(1500);
					
			
			}
		});
		
				$('.tokyobox').each(function()/* .each()で、「.tokyobox」が付いた要素1つずつに順番に処理 */{
			
				/* .scrollTop()で、スクロールした量を取得して、変数scrollに代入 */
				var scroll = $(window).scrollTop();
				
				/* .offset().topで、ページの最上部から「.tokyobox」が付いた要素までの距離を取得して、変数positionに代入 */
				var position =  $(this).offset().top;
				
				/* .height()で、ウィンドウの高さを取得して、変数windowHeightに代入 */
				var windowHeight = $(window).height();
				
				/* スクロール量が、「ページ最上部から要素までの距離」-「ウィンドウの高さ」を超えた時 */
				if (scroll > position - windowHeight + 1150){
					
					$('.tokyobox').fadeIn(6000);/* 「.tokyobox」を徐々に表示 */
					
					}else{
					
					$('.tokyobox').fadeout(1500);
						
					
			}
		});
	
 	});
 });