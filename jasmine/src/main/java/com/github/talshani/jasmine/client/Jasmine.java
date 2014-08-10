package com.github.talshani.jasmine.client;

/**
 * @author Tal Shani
 */
public class Jasmine {

    public static final void describe(String text, DescribeCallback define) {
        defineFn("describe", text, define);
    }

    public static final void xdescribe(String text, DescribeCallback define) {
        defineFn("xdescribe", text, define);
    }

    public static final void describe(String text) {
        defineFn("describe", text, null);
    }

    public static final void xdescribe(String text) {
        defineFn("xdescribe", text, null);
    }

    public static final void it(String text, JasmineCallback define) {
        defineFn("it", text, define);
    }

    public static final void xit(String text, JasmineCallback define) {
        defineFn("xit", text, define);
    }

    public static final void it(String text) {
        defineFn("it", text, null);
    }

    public static final void xit(String text) {
        defineFn("xit", text, null);
    }

    public static final void beforeEach(JasmineCallback define) {
        defineFn("beforeEach", define);
    }

    public static final void afterEach(JasmineCallback define) {
        defineFn("afterEach", define);
    }

    public static final native ExpectationBuilder expect(Object o) /*-{
      return $wnd.expect(o);
    }-*/;

    private static native void defineFn(String fn, String text, JasmineCallback define) /*-{
      if (!define) {
        $wnd[fn](text);
      } else {
        $wnd[fn](text, function (done) {
          $entry(function() {
            var cmd = @com.github.talshani.jasmine.client.DoneCallback::wrapFn(Lcom/google/gwt/core/client/JavaScriptObject;)(done);
            define.@com.github.talshani.jasmine.client.JasmineCallback::callDefine(Lcom/github/talshani/jasmine/client/DoneCallback;)(cmd)
          })()
        })
      }
    }-*/;

    private static native void defineFn(String fn, JasmineCallback define) /*-{
      $wnd[fn](text, function (done) {
        $entry(function() {
          var cmd = @com.github.talshani.jasmine.client.DoneCallback::wrapFn(Lcom/google/gwt/core/client/JavaScriptObject;)(done);
          define.@com.github.talshani.jasmine.client.JasmineCallback::callDefine(Lcom/github/talshani/jasmine/client/DoneCallback;)(cmd)
        })()
      })
    }-*/;
}
