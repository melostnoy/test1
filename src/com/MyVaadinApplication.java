package com;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import java.io.File;


@Theme("valo")

public class MyVaadinApplication extends UI {

    private TreeTable tableForDownload = new TreeTable("Файлы на сервере");
    private Button downloadButton = new Button("Загрузить файл");
    private  FormLayout uploadLayout = new FormLayout();

    FilesystemContainer files = new FilesystemContainer(new File(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()));

    @Override
    public void init(VaadinRequest request) {

        initLayout();
        initFileSelect();
        initUpload();
        initDownloadButton();

    }

    private void initLayout() {

        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        setContent(splitPanel);
        VerticalLayout leftLayout = new VerticalLayout();
        leftLayout.setMargin(true);
        splitPanel.addComponent(leftLayout);
        splitPanel.addComponent(uploadLayout);
        leftLayout.addComponent(tableForDownload);
        HorizontalLayout bottomLeftLayout = new HorizontalLayout();
        leftLayout.addComponent(bottomLeftLayout);
        bottomLeftLayout.addComponent(downloadButton);
        uploadLayout.setMargin(true);

    }

    private void initFileSelect() {

        tableForDownload.setContainerDataSource(files);
        tableForDownload.setSelectable(true);
        tableForDownload.setImmediate(true);

    }

    private void initUpload() {

        Upload upload = new Upload();
        uploadLayout.addComponent(upload);

    }

    private  void initDownloadButton() {

        downloadButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
            }
        });

    }

}