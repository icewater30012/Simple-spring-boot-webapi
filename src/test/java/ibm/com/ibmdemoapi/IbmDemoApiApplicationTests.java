package ibm.com.ibmdemoapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IbmDemoApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnDataset() throws Exception {
		String expectedContent = "[\n" +
				"  {\n" +
				"    \"member_id\": \"001\",\n" +
				"    \"name\": \"Alice Chen\",\n" +
				"    \"email\": \"alice.chen@example.com\",\n" +
				"    \"phone\": \"0912345678\",\n" +
				"    \"address\": \"123 Main St, Taipei City, Taiwan\",\n" +
				"    \"join_date\": \"2023-05-15\"\n" +
				"  },\n" +
				"  {\n" +
				"    \"member_id\": \"002\",\n" +
				"    \"name\": \"Bob Lin\",\n" +
				"    \"email\": \"bob.lin@example.com\",\n" +
				"    \"phone\": \"0923456789\",\n" +
				"    \"address\": \"456 Oak St, Kaohsiung City, Taiwan\",\n" +
				"    \"join_date\": \"2023-06-20\"\n" +
				"  },\n" +
				"  {\n" +
				"    \"member_id\": \"003\",\n" +
				"    \"name\": \"Cathy Wang\",\n" +
				"    \"email\": \"cathy.wang@example.com\",\n" +
				"    \"phone\": \"0934567890\",\n" +
				"    \"address\": \"789 Pine St, Tainan City, Taiwan\",\n" +
				"    \"join_date\": \"2023-07-10\"\n" +
				"  },\n" +
				"  {\n" +
				"    \"member_id\": \"004\",\n" +
				"    \"name\": \"David Lee\",\n" +
				"    \"email\": \"david.lee@example.com\",\n" +
				"    \"phone\": \"0945678901\",\n" +
				"    \"address\": \"101 Maple St, Taichung City, Taiwan\",\n" +
				"    \"join_date\": \"2023-08-05\"\n" +
				"  }\n" +
				"]";

		mockMvc.perform(get("/api/getJsonData"))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedContent));
	}
}
