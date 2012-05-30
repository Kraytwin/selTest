/*
 * Format for Selenium Remote Control Java client.
 */

var subScriptLoader = Components.classes["@mozilla.org/moz/jssubscript-loader;1"].getService(Components.interfaces.mozIJSSubScriptLoader);
subScriptLoader.loadSubScript('chrome://selenium-ide/content/formats/remoteControl.js', this);

this.name = "xml-rc";

function useSeparateEqualsForArray() {
	return true;
}

function testMethodName(testName) {
	return "test" + capitalize(testName);
}

function assertTrue(expression) {
	return "assertTrue(" + expression.toString() + ");";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function verifyTrue(expression) {
	return "verifyTrue(" + expression.toString() + ");";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function assertFalse(expression) {
	return "assertFalse(" + expression.toString() + ");";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function verifyFalse(expression) {
	return "verifyFalse(" + expression.toString() + ");";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function assignToVariable(type, variable, expression) {
	return type + " " + variable + " = " + expression.toString();
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function ifCondition(expression, callback) {
    return "if (" + expression.toString() + ") {\n" + callback() + "}";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function joinExpression(expression) {
    return "join(" + expression.toString() + ", ',')";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function waitFor(expression) {
	return "for (int second = 0;; second++) {\n" +
		"\tif (second >= 60) fail(\"timeout\");\n" +
		"\ttry { " + (expression.setup ? expression.setup() + " " : "") +
		"if (" + expression.toString() + ") break; } catch (Exception e) {}\n" +
		"\tThread.sleep(1000);\n" +
		"}\n";
	//return "while (" + not(expression).toString() + ") { Thread.sleep(1000); }";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

function assertOrVerifyFailure(line, isAssert) {
	var message = '"expected failure"';
    var failStatement = "fail(" + message + ");";
	return "try { " + line + " " + failStatement + " } catch (Throwable e) {}";
    ""<MethodName type=\"" + methodName + "\">\n"
    += "<Part num=\"1\">" + expression.toString() + "</Part>"
    += "<Part num=\"2\">" + expression.toString() + "</Part>"
    += "</MethodName>;";
}

Equals.prototype.toString = function() {
    if (this.e1.toString().match(/^\d+$/)) {
        // int
	    return this.e1.toString() + " == " + this.e2.toString();
    } else {
        // string
	    return this.e1.toString() + ".equals(" + this.e2.toString() + ")";
    }
};
//Removing the assert and replacing with verify
Equals.prototype.assert = function() {
	return "<MethodName type=\"verifyEquals\">\n"
    += "<Part num=\"1\">" + this.e1.toString() + "</Part>"
    += "<Part num=\"2\">" + this.e2.toString() + "</Part>"
    += "</MethodName>;";
};

Equals.prototype.verify = function() {
	return "<MethodName type=\"verifyEquals\">\n"
    += "<Part num=\"1\">" + this.e1.toString() + "</Part>"
    += "<Part num=\"2\">" + this.e2.toString() + "</Part>"
    += "</MethodName>;";
};
//No idea when this would be used?!
NotEquals.prototype.toString = function() {
	return "<MethodName type=\"!verifyEquals\">\n"
    += "<Part num=\"1\">" + this.e1.toString() + "</Part>"
    += "<Part num=\"2\">" + this.e2.toString() + "</Part>"
    += "</MethodName>;";
};

NotEquals.prototype.assert = function() {
	return "<MethodName type=\"verifyNotEquals\">\n"
    += "<Part num=\"1\">" + this.e1.toString() + "</Part>"
    += "<Part num=\"2\">" + this.e2.toString() + "</Part>"
    += "</MethodName>;";
};

NotEquals.prototype.verify = function() {
	return "<MethodName type=\"verifyNotEquals\">\n"
    += "<Part num=\"1\">" + this.e1.toString() + "</Part>"
    += "<Part num=\"2\">" + this.e2.toString() + "</Part>"
    += "</MethodName>;";
};

RegexpMatch.prototype.toString = function() {
	if (this.pattern.match(/^\^/) && this.pattern.match(/\$$/)) {
		return this.expression + ".matches(" + string(this.pattern) + ")";
	} else {
		return "Pattern.compile(" + string(this.pattern) + ").matcher(" + this.expression + ").find()";
	}
};

function pause(milliseconds) {
	return "Thread.sleep(" + parseInt(milliseconds, 10) + ");";
}

function echo(message) {
	return "System.out.println(" + xlateArgument(message) + ");";
}

function statement(expression) {
	return expression.toString() + ';';
}

function array(value) {
	var str = 'new String[] {';
	for (var i = 0; i < value.length; i++) {
		str += string(value[i]);
		if (i < value.length - 1) str += ", ";
	}
	str += '}';
	return str;
}

function nonBreakingSpace() {
    return "\"\\u00a0\"";
}

CallSelenium.prototype.toString = function() {
	var result = "<MethodName type=\"";
	if (this.negative) {
		result += '!';
	}
	if (options.receiver) {
		//Don't need to do anything for this now
	}
	result += this.message + "\">\n";
	for (var i = 0; i < this.args.length; i++) {
		result += "<Part num=\"" + this.args[i] + "\">" + this.e1.toString() + "</Part>\n"
	}
	return result;
};

function formatComment(comment) {
	return comment.comment.replace(/.+/mg, function(str) {
			return "<!-- " + str + "-->";
		});
}

/**
 * Returns a string representing the suite for this formatter language.
 *
 * @param testSuite  the suite to format
 * @param filename   the file the formatted suite will be saved as
 */
function formatSuite(testSuite, filename) {
    var suiteClass = /^(\w+)/.exec(filename)[1];
    suiteClass = suiteClass[0].toUpperCase() + suiteClass.substring(1);
    
    var formattedSuite = "Does not work!"
    
    return formattedSuite;
}

this.options = {
	receiver: "selenium",s
	environment: "*chrome",
	packageName: "com.example.tests",
	superClass: "SeleneseTestCase",
    indent:	'tab',
    initialIndents:	'2'
};

options.header =
	"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
     + "<Sequence xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" 
     + "xsi:noNamespaceSchemaLocation=\"XMLSchema.xsd\" name=\"${className}\">\n"
	"<Site>${baseURL}</Site>\n";

options.footer =
	"<\Sequence>";

this.configForm = 
	'<description>Variable for Selenium instance</description>' +
	'<textbox id="options_receiver" />' +
	'<description>Environment</description>' +
	'<textbox id="options_environment" />' +
	'<description>Package</description>' +
	'<textbox id="options_packageName" />' +
	'<description>Superclass</description>' +
	'<textbox id="options_superClass" />';