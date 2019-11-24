(function webpackUniversalModuleDefinition(root, factory) {
	if(typeof exports === 'object' && typeof module === 'object')
		module.exports = factory(require("lodash"));
	else if(typeof define === 'function' && define.amd)
		define(["lodash"], factory);
	else if(typeof exports === 'object')
		exports["componentsHooks"] = factory(require("lodash"));
	else
		root["componentsHooks"] = factory(root["_"]);
})((typeof self !== 'undefined' ? self : this), function(__WEBPACK_EXTERNAL_MODULE__2__) {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "https://static.parastorage.com/services/wix-ui-santa/1.666.0/";
/******/
/******/
/******/ 	__webpack_require__.p = typeof window !== 'undefined' && window.__STATICS_BASE_URL__ || __webpack_require__.p;
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 1046);
/******/ })
/************************************************************************/
/******/ ({

/***/ 1046:
/*!****************************!*\
  !*** ./componentsHooks.js ***!
  \****************************/
/*! no static exports found */
/*! all exports used */
/*! ModuleConcatenation bailout: Module is not an ECMAScript module */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});

var _hooks = __webpack_require__(/*! ./components/Slider/hooks */ 861);

var _hooks2 = _interopRequireDefault(_hooks);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = {
  'wixui.Slider': _hooks2.default
};

/***/ }),

/***/ 2:
/*!*************************************************************************************!*\
  !*** external {"amd":"lodash","commonjs":"lodash","commonjs2":"lodash","root":"_"} ***!
  \*************************************************************************************/
/*! no static exports found */
/*! all exports used */
/*! ModuleConcatenation bailout: Module is not an ECMAScript module */
/***/ (function(module, exports) {

module.exports = __WEBPACK_EXTERNAL_MODULE__2__;

/***/ }),

/***/ 861:
/*!************************************!*\
  !*** ./components/Slider/hooks.js ***!
  \************************************/
/*! no static exports found */
/*! all exports used */
/*! ModuleConcatenation bailout: Module is not an ECMAScript module */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});

var _lodash = __webpack_require__(/*! lodash */ 2);

var _lodash2 = _interopRequireDefault(_lodash);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

function updateOrientationLayout(prevLayout) {
  return _lodash2.default.assign({}, prevLayout, {
    width: prevLayout.height,
    height: prevLayout.width
  });
}

function getTicksSize(tickShape, tickPosition) {
  if (tickPosition === 'middle') {
    return 0;
  }

  switch (tickShape) {
    default:
    case 'line':
      return 22;
    case 'dot':
      return 15;
    case 'none':
      return 0;
  }
}

function shouldShowTicks(data, props) {
  return data.step > 0 && props.tickMarksShape !== 'none';
}

function updateTicksLayout(_ref) {
  var prevLayout = _ref.prevLayout,
      prevProps = _ref.prevProps,
      nextProps = _ref.nextProps,
      prevData = _ref.prevData,
      nextData = _ref.nextData;

  var lastShowTicks = shouldShowTicks(prevData, prevProps);
  var showTicks = shouldShowTicks(nextData, nextProps);
  var lastSize = lastShowTicks ? getTicksSize(prevProps.tickMarksShape, prevProps.tickMarksPosition) : 0;
  var size = showTicks ? getTicksSize(nextProps.tickMarksShape, nextProps.tickMarksPosition) : 0;
  var sizeDiff = size - lastSize;
  var dim = nextProps.orientation === 'horizontal' ? 'height' : 'width';

  return _lodash2.default.assign({}, prevLayout, _defineProperty({}, dim, prevLayout[dim] + sizeDiff));
}

function didOrientationChange(prevProps, nextProps) {
  return nextProps.orientation && prevProps.orientation && nextProps.orientation !== prevProps.orientation;
}

function didTicksChange(prevProps, nextProps, prevData, nextData) {
  var lastShowTicks = shouldShowTicks(prevData, prevProps);
  var nextShowTicks = shouldShowTicks(nextData, nextProps);
  var lastTickMarksShape = prevProps.tickMarksShape;
  var nextTickMarksShape = nextProps.tickMarksShape;
  var lastTickMarksPosition = prevProps.tickMarksPosition;
  var nextTickMarksPosition = nextProps.tickMarksPosition;

  return lastShowTicks !== nextShowTicks || lastTickMarksShape !== nextTickMarksShape || lastTickMarksPosition !== nextTickMarksPosition;
}

var beforeUpdate = function beforeUpdate(_ref2) {
  var compDriver = _ref2.compDriver,
      prevProps = _ref2.prevProps,
      nextProps = _ref2.nextProps,
      prevData = _ref2.prevData,
      nextData = _ref2.nextData;

  var prevLayout = compDriver.layout.get();
  var newLayout = void 0;

  if (didOrientationChange(prevProps, nextProps)) {
    newLayout = updateOrientationLayout(prevLayout);
  } else if (didTicksChange(prevProps, nextProps, prevData, nextData)) {
    newLayout = updateTicksLayout({ prevLayout: prevLayout, prevProps: prevProps, nextProps: nextProps, prevData: prevData, nextData: nextData });
  }

  if (newLayout) {
    compDriver.layout.update(newLayout);
  }
};

var beforeUpdateProperties = function beforeUpdateProperties(compDriver, nextProps) {
  var prevProps = compDriver.properties.get();
  var prevData = compDriver.data.get();
  return beforeUpdate({ compDriver: compDriver, prevProps: prevProps, nextProps: nextProps, prevData: prevData, nextData: prevData });
};

var beforeUpdateData = function beforeUpdateData(compDriver, nextData) {
  var prevProps = compDriver.properties.get();
  var prevData = compDriver.data.get();
  return beforeUpdate({ compDriver: compDriver, prevProps: prevProps, nextProps: prevProps, prevData: prevData, nextData: nextData });
};

var getSize = function getSize(currentLayout, nextLayout) {
  return {
    width: nextLayout.width || currentLayout.width,
    height: nextLayout.height || currentLayout.height
  };
};

var beforeUpdateLayout = function beforeUpdateLayout(compDriver, nextLayout) {
  if (!nextLayout.width && !nextLayout.height) {
    return;
  }

  var currentLayout = compDriver.layout.get();
  var compProperties = compDriver.properties.get();

  var _getSize = getSize(currentLayout, nextLayout),
      width = _getSize.width,
      height = _getSize.height;

  var newLayout = _lodash2.default.cloneDeep(nextLayout);

  if (compProperties.orientation === 'vertical') {
    var minHeight = 4 * width;
    newLayout.height = Math.max(height, minHeight);
  } else if (compProperties.orientation === 'horizontal') {
    var minWidth = 4 * height;
    newLayout.width = Math.max(width, minWidth);
  }

  compDriver.layout.update(newLayout);
};

var hooks = {
  beforeUpdateProperties: beforeUpdateProperties,
  beforeUpdateData: beforeUpdateData,
  beforeUpdateLayout: beforeUpdateLayout
};

exports.default = hooks;

/***/ })

/******/ });
});
//# sourceMappingURL=componentsHooks.bundle.js.map