package com.watom.pdflibrary.main;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.github.barteksc.pdfviewer.PDFView;
import com.watom.pdflibrary.R;

public class IReadPdfActivity extends Activity {
    private PDFView pdfView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ireader_pdf);
        initView();
    }

    private void initView() {
        pdfView = findViewById(R.id.ireader_pdf_view);
        displayFromFile("android内核剖析.pdf");
    }

    private void displayFromFile(String fileName) {
        pdfView.fromAsset(fileName).defaultPage(1).load();
    }

}
