package com.tiantianchiji.onlineexam;

import com.tiantianchiji.onlineexam.controllers.EndUserController;
import com.tiantianchiji.onlineexam.services.EndUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(EndUserController.class)
public class EndUserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EndUserService endUserService;

    @Test
    public void testLogin() throws Exception {
        given(this.endUserService.login("bzhou", "123456"))
              .willReturn("123456");
        ResultActions retActions = this.mvc.perform(post("/users/tokens").contentType(MediaType.APPLICATION_JSON).content("{\"username\":\"bzhou\",\"password\":\"123456\"}"));
        return;
    }
}
