package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.DoctorDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/SubmitData")
@MultipartConfig
public class SubmitData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the form inputs
        String doctorName = request.getParameter("doctorName");
        String bachelor = request.getParameter("bachelor");
        String arrivingTime = request.getParameter("arrivingTime");
        String departTime = request.getParameter("departTime");

        // Retrieve the uploaded image
        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();

        // Define the upload directory (e.g., "uploads" folder in the webapp directory)
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Save the file with a unique name
        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
        File file = new File(uploadPath + File.separator + uniqueFileName);
        filePart.write(file.getAbsolutePath());

        // Create a DoctorDetails object to hold the doctor’s details
        DoctorDetails doctorDetails = new DoctorDetails(doctorName, bachelor, arrivingTime, departTime, uniqueFileName);

        // Retrieve and update the list of DoctorDetails objects in the session
        @SuppressWarnings("unchecked")
        List<DoctorDetails> doctorList = (List<DoctorDetails>) request.getSession().getAttribute("doctorList");
        if (doctorList == null) {
            doctorList = new ArrayList<>();
        }
        doctorList.add(doctorDetails);
        request.getSession().setAttribute("doctorList", doctorList);

        // Forward the request to the result page
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
