package jasmine.example.client;

import com.github.talshani.jasmine.client.DescribeCallback;
import com.google.gwt.core.client.EntryPoint;

import static com.github.talshani.jasmine.client.Jasmine.describe;
import static com.github.talshani.jasmine.client.Jasmine.expect;
import static com.github.talshani.jasmine.client.Jasmine.it;

/**
 * @author Tal Shani
 */
public class JasmineExample implements EntryPoint {
    public void onModuleLoad() {
        describe("some test", new DescribeCallback() {
            @Override
            protected void doDescribe() {
                it("should do this thing", new DescribeCallback() {
                    @Override
                    protected void doDescribe() {
                        expect(1).toBe(1);
                    }
                });
            }
        });
        describe("some test 2", new DescribeCallback() {
            @Override
            protected void doDescribe() {
                it("should do this thing2", new DescribeCallback() {
                    @Override
                    protected void doDescribe() {
                        expect(2).toBe(1);
                    }
                });
            }
        });
    }

}
