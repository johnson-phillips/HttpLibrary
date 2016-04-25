import http.HTTPRequest;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HttpTest {

    HTTPRequest request = new HTTPRequest();
    HttpResponse response = null;
    int code;
    String result;

    @Test(description="Test Http Get")
    public void HttpGetTest()
    {
        try
        {
           response = request.GetData("http://httpbin.org/get");
            code = response.getStatusLine().getStatusCode();
            Assert.assertEquals(code,200);
            result = EntityUtils.toString(response.getEntity());
            System.out.print(result);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
            Assert.fail();
        }
    }

    @Test(description="Test Http Post")
    public void HttpPostTest()
    {
        try
        {
            response = request.PostData("http://httpbin.org/post","Test Data");
            code = response.getStatusLine().getStatusCode();
            Assert.assertEquals(code,200);
            result = EntityUtils.toString(response.getEntity());
            System.out.print(result);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
            Assert.fail();
        }
    }
}
