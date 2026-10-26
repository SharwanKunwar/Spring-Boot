package org.unpredictableXpractice;

import org.unpredictableXpractice.repository.StudentRepository;


public class Main
{
    static void main(String[] args)
    {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.create();

    }
}
