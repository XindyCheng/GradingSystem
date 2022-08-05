/* -----------------------------------------------------------------------------

File:           JS Core
Version:        1.0
Author:         

-------------------------------------------------------------------------------- */
(function() {

	"use strict";

	var Appilo = {
		init: function() {
			this.Basic.init();  
		},

		Basic: {
			init: function() {
				this.preloader();
				this.BackgroundImage();
				this.bannerStyle();
				this.Animation();
				this.scrollTop();
			},

			preloader: function (){
				jQuery(window).on('load', function(){
					jQuery('#preloader').fadeOut('slow',function(){jQuery(this).remove();});
				});
			},
			BackgroundImage: function (){
				$('[data-background]').each(function() {
					$(this).css('background-image', 'url('+ $(this).attr('data-background') + ')');
				});
			},
			bannerStyle: function() {
				var win = jQuery(window),
				foo = jQuery('#typer');
				foo.typer(['Wizard','Wizard', 'Wizard' ]);           
				win.resize(function(){
					var fontSize = Math.max(Math.min(win.width() / (1 * 5), parseFloat(Number.POSITIVE_INFINITY)), parseFloat(Number.NEGATIVE_INFINITY));

				}).resize();

			},
			Animation: function (){
				AOS.init({
					once:true,
					duration:1000,
				});
			},
			scrollTop: function (){
				$(window).on("scroll", function() {
					if ($(this).scrollTop() > 200) {
						$('.scrollup').fadeIn();
					} else {
						$('.scrollup').fadeOut();
					}
				});

				$('.scrollup').on("click", function()  {
					$("html, body").animate({
						scrollTop: 0
					}, 800);
					return false;
				});

			}

/* End Of js
================================================*/
}
}
jQuery(document).ready(function (){
	Appilo.init();
});

})();