var DigiForm = {
	/**
	 * 获取隐藏表单
	 * @param {} action
	 * @param {} target
	 * @return {}
	 */
	getHiddenForm: function(action, target) {
		var ret = document.createElement("form");
		ret.setAttribute("method", "POST");
		var a = action || null;
		var t = target || null;
		if (null != a) ret.setAttribute("action", action);
		if (null != t) ret.setAttribute("target", target);
		return ret;
	},
	/**
	 * 获取隐藏输入域
	 * @param {} name
	 * @param {} val
	 * @return {}
	 */
	getHiddenInput: function(name, val) {
		var ret = document.createElement("input");
		ret.setAttribute("name", name);
		ret.setAttribute("id", name);
		ret.setAttribute("type", "hidden");
		ret.setAttribute("value", val);
		return ret;
	},
	appendForm: function(form) {
		document.body.appendChild(form);
	}
};