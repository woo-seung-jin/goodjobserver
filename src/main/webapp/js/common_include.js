var context = '../../../';
var epostContext = context + '';
var division = location.href;

//for Error Page
if(division.indexOf('error') != -1){ epostContext = ''; }

//for Error Page
if(division.indexOf('otp') != -1){ epostContext = ''; }

//<!-- framework css -->
document.writeln('<link rel="stylesheet" href="' + epostContext + 'hbfw/css/jquery.mobile-1.2.css" />');
document.writeln('<link rel="stylesheet" href="' + epostContext + 'hbfw/css/sds.css" />');
document.writeln('<link rel="stylesheet" href="' + epostContext + 'css/style_card.css" />');

//<!-- framework js -->
document.writeln('<script src="' + epostContext + 'hbfw/js/MDHAdapter.js"></script>');
document.writeln('<script src="' + epostContext + 'hbfw/js/espresso.emulator.js"></script>');
document.writeln('<script src="' + epostContext + 'hbfw/js/jquery-1.8.2.js"></script>');
document.writeln('<script src="' + epostContext + 'hbfw/js/jquery.mobile-1.2.js"></script>');
document.writeln('<script src="' + epostContext + 'hbfw/js/sui.fixedtoolbar.config.js"></script>');
document.writeln('<script src="' + epostContext + 'hbfw/js/MDHConfig.js"></script>');

//<!-- util js -->
document.writeln('<script src="' + epostContext + 'js/epostUtil.js"></script>');

//크롬 테스트
document.writeln('<script src="' + epostContext + 'js/testData.js"></script>');

//<!-- epost js -->

document.writeln('<script src="' + epostContext + 'mmap/gcenmap.js"></script>');
//document.writeln('<script src="' + epostContext + 'mmap/basetype.js"></script>');
//document.writeln('<script src="' + epostContext + 'mmap/excanvas.js"></script>');
//document.writeln('<script src="' + epostContext + 'mmap/maps.js"></script>');
//document.writeln('<script src="' + epostContext + 'mmap/system.js"></script>');

document.writeln('<script src="' + epostContext + 'js/sub_common_util.js"></script>');
document.writeln('<script src="' + epostContext + 'js/epost_value.js"></script>');
//document.writeln('<script src="' + epostContext + 'js/testData.js"></script>');
document.writeln('<script src="' + epostContext + 'js/epost_common.js"></script>');
document.writeln('<script src="' + epostContext + 'js/webStorageKeyMap.js"></script>');
document.writeln('<script src="' + epostContext + 'mmap/jquery.xml2json.js"></script>');
document.writeln('<script src="' + epostContext + 'mmap/mapTestData.js"></script>');

// navigation bar include
document.writeln('<script src="' + epostContext + 'js/epost_navigation.js"></script>');

// secure card include
document.writeln('<script src="' + epostContext + 'js/epost_securecard.js"></script>');

// pin include
document.writeln('<script src="' + epostContext + 'js/epost_pin_include.js"></script>');

// slide
document.writeln('<script src="' + epostContext + 'js/jssor.slider.min.js"></script>');
