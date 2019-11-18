package ru.stacy.business.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.stacy.business.entity.Album;
import ru.stacy.business.entity.Band;
import ru.stacy.business.entity.MusicBlock;
import ru.stacy.business.service.BandService;
import ru.stacy.web.dto.AlbumDTO;
import ru.stacy.web.dto.BandDTO;
import ru.stacy.web.dto.MusicBlockDTO;
import ru.stacy.web.dto.MusicianDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.stacy.web.api.ApiController.BAND;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BandServiceImplTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private BandService bandService;

    @Autowired
    private ObjectMapper objectMapper;

    @Rule
    public JUnitRestDocumentation jUnitRestDocumentation = new JUnitRestDocumentation();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(this.jUnitRestDocumentation) )
                .build();
    }

    public String toJson(BandDTO band) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(band);
    }

    private BandDTO getBandDTO() {
        BandDTO band = new BandDTO();
        band.setName("Slipknot");
        band.setGenre("Nu metal");
        band.setCreatedDate(LocalDate.now());

        AlbumDTO album = new AlbumDTO();
        album.setName("Disasterpiece");
        album.setCreatedDate(LocalDate.now());

        List<AlbumDTO> albums = new ArrayList<>();
        albums.add(album);

        MusicianDTO musician = new MusicianDTO();
        musician.setName("Mick Thompson");

        List<MusicianDTO> musicians = new ArrayList<>();
        musicians.add(musician);

        MusicBlockDTO musicBlock = new MusicBlockDTO();
        musicBlock.setName("Nu metal");

        band.setAlbums(albums);
        band.setMusicians(musicians);
        band.setMusicBlock(musicBlock);

        return band;
    }

    @Test
    public void findAll() throws Exception {
        this.mockMvc.perform(RestDocumentationRequestBuilders.get(BAND))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(
                        document("bands/find-all",
                            responseFields(
                                    subsectionWithPath("[].id").description("Идентификатор группы"),
                                    subsectionWithPath("[].name").description("Название группы"),
                                    subsectionWithPath("[].genre").description("Жанр группы"),
                                    subsectionWithPath("[].createdDate").description("Дата создания группы"),
                                    subsectionWithPath("[].albums").description("Выпущенные альбомы группы"),
                                    subsectionWithPath("[].musicians").description("Музыканты группы"),
                                    subsectionWithPath("[].musicBlock").description("Музыкальная колонка, в которой отображается группа")
                            )
                        )
                );
    }

    @Test
    public void findById() throws Exception {
        this.mockMvc.perform(RestDocumentationRequestBuilders.get(BAND + "/{id}", 4L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(
                        document("bands/find-by-id",
                                pathParameters(parameterWithName("id").description("Идентификатор группы, которую нужно получить")),
                                responseFields(
                                        subsectionWithPath("id").description("Идентификатор группы"),
                                        subsectionWithPath("name").description("Название группы"),
                                        subsectionWithPath("genre").description("Жанр группы"),
                                        subsectionWithPath("createdDate").description("Дата создания группы"),
                                        subsectionWithPath("albums").description("Выпущенные альбомы группы"),
                                        subsectionWithPath("musicians").description("Музыканты группы"),
                                        subsectionWithPath("musicBlock").description("Музыкальная колонка, в которой отображается группа")
                                )
                        )
                );
    }

    @Test
    public void save() throws Exception {
        BandDTO band = getBandDTO();

        this.mockMvc.perform(RestDocumentationRequestBuilders.post(BAND)
                .content(toJson(band))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(
                        document("bands/save",
                                requestFields(
                                        subsectionWithPath("name").description("Название группы"),
                                        subsectionWithPath("genre").description("Жанр группы"),
                                        subsectionWithPath("createdDate").description("Дата создания группы"),
                                        subsectionWithPath("albums").description("Выпущенные альбомы группы"),
                                        subsectionWithPath("musicians").description("Музыканты группы"),
                                        subsectionWithPath("musicBlock").description("Музыкальная колонка, в которой отображается группа")
                                ),
                                responseFields(subsectionWithPath("id").description("Идентификатор созданной группы"))
                        )
                )
                .andExpect(status().isOk());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}