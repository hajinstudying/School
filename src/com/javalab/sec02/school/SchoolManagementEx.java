package com.javalab.sec02.school;

import java.util.Scanner;

public class SchoolManagementEx {
    private static DataRepository repo = new DataRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("학사 행정관리 프로그램");
            System.out.println("=============================");
            System.out.println("1. 학생관련 업무");
            System.out.println("2. 교수 관련 업무");
            System.out.println("3. 학과 관련 업무");
            System.out.println("4. 성적관련 업무");
            System.out.println("5. 종료");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    professorMenu();
                    break;
                case 3:
                    departmentMenu();
                    break;
                case 4:
                    takesMenu();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 학생 등록");
            System.out.println("2. 학생 조회");
            System.out.println("3. 학생 정보 수정");
            System.out.println("4. 학생 정보 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerStudent(Scanner scanner) {
        System.out.println("학생 ID: ");
        String id = scanner.nextLine();
        System.out.println("주민번호: ");
        String jumin = scanner.nextLine();
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("학년: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("주소: ");
        String address = scanner.nextLine();
        System.out.println("학과 코드: ");
        int department = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(id, jumin, name, year, address, department);
        repo.getStudents().add(student);
        System.out.println("학생이 성공적으로 등록되었습니다.");
    }

    private static void displayStudents() {
        System.out.println("등록된 학생 목록:");
        for (Student s : repo.getStudents()) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getYear() + " " + s.getAddress() + " " + s.getDepartment());
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.println("수정할 학생의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (Student s : repo.getStudents()) {
            if (s.getId().equals(id)) {
                System.out.println("새 주민번호: ");
                String jumin = scanner.nextLine();
                System.out.println("새 이름: ");
                String name = scanner.nextLine();
                System.out.println("새 학년: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("새 주소: ");
                String address = scanner.nextLine();
                System.out.println("새 학과 코드: ");
                int department = scanner.nextInt();
                scanner.nextLine();

                s.setJumin(jumin);
                s.setName(name);
                s.setYear(year);
                s.setAddress(address);
                s.setDepartment(department);
                System.out.println("학생 정보가 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
    }
    private static void deleteStudent(Scanner scanner) {
        System.out.println("삭제할 학생의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (int i = 0; i < repo.getStudents().size(); i++) {
            if (repo.getStudents().get(i).getId().equals(id)) {
                repo.getStudents().remove(i);
                System.out.println("학생 정보가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
    }

    private static void professorMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("=============================");
            System.out.println("1. 교수 등록");
            System.out.println("2. 교수 조회");
            System.out.println("3. 교수 이름 검색");  //추가된 부분
            System.out.println("4. 교수 정보 수정");
            System.out.println("5. 교수 정보 삭제");  //삭제 확인 추가
            System.out.println("6. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();//버퍼 비우기

            switch (choice) {
                case 1:
                    registerProfessor(scanner);
                    break;
                case 2:
                    displayProfessor();
                    break;
                case 3:
                    searchProfessor(scanner);
                    break;
                case 4:
                    updateProfessor(scanner);
                    break;
                case 5:
                    deleteProfessor(scanner);
                case 6:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerProfessor(Scanner scanner){
        System.out.println("교수 ID: ");
        String id = scanner.nextLine();
        System.out.println("주민번호: ");
        String jumin = scanner.nextLine();
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("학과 코드: ");
        int department = scanner.nextInt();
        scanner.nextLine(); //버퍼 비우기
        System.out.println("직급: ");
        String grade = scanner.nextLine();
        System.out.println("입사년도: ");
        String hiredate = scanner.nextLine();

        Professor professor = new Professor(id, jumin, name, department, grade, hiredate);
        repo.getProfessors().add(professor);
        System.out.println("교수가 성공적으로 등록되었습니다.");
    }

    private static void displayProfessor() {
        System.out.println("등록된 교수 목록");
        for (Professor p : repo.getProfessors()){
            System.out.println(p.getId() + " " + p.getName() + " " + p.getDepartment() + " " + p.getGrade() + " " + p.getHiredate());
        }
    }

    private static void searchProfessor(Scanner scanner){
        System.out.println("검색할 교수의 이름을 입력하세요: ");
        String name = scanner.nextLine();
        boolean found = false;  //검색 여부 플래그 변수
        for(Professor p : repo.getProfessors()){
            if(p.getName().equals(name)){
                System.out.println(p);
                found = true;
            }
        }
        if(!found) {
            System.out.println("해당 이름의 교수를 찾을 수 없습니다.");
        }
    }

    private static void updateProfessor(Scanner scanner) {
        System.out.println("수정할 교수의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (Professor f : repo.getProfessors()) {
            if(f.getId().equals(id)){
                System.out.println("새 주민번호: ");
                String jumin = scanner.nextLine();
                System.out.println("새 이름: ");
                String name = scanner.nextLine();
                System.out.println("새 학과 코드: ");
                int department = scanner.nextInt();
                scanner.nextLine();
                System.out.println("새 직급: ");
                String grade = scanner.nextLine();
                System.out.println("새 입사년도: ");
                String hiredate = scanner.nextLine();

                f.setName(name);
                f.setJumin(jumin);
                f.setDepartment(department);
                f.setGrade(grade);
                f.setHiredate(hiredate);
                System.out.println("교수 정보가 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 교수를 찾을 수 없습니다.");
    }

    private static void deleteProfessor(Scanner scanner) {
        System.out.println("삭제할 교수의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (int i = 0; i < repo.getProfessors().size(); i++){
            if(repo.getProfessors().get(i).getId().equals(id)) {
                System.out.println(repo.getProfessors().get(i));

                System.out.println("해당 교수를 삭제하시겠습니까?(y / n): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    repo.getProfessors().remove(i);
                    System.out.println("교수 정보가 삭제되었습니다.");
                    return;
                } else if (confirm.equalsIgnoreCase("N")) {
                    System.out.println("삭제가 취소되었습니다.");
                    return;
                }
                System.out.println("잘못 입력하셨습니다.");
                break;
            }
        }
        System.out.println("해당 ID의 교수를 찾을 수 없습니다.");
    }
    private static void departmentMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 교실 조회");
            System.out.println("2. 교실 예약");
            System.out.println("3. 교실 예약 수정");
            System.out.println("4. 교실 예약 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    displayClassroom();
                    break;
                case 2:
                    reserveClassroom(scanner);
                    break;
                case 3:
                    updateClassroom(scanner);
                    break;
                case 4:
                    deleteClassroom(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void displayClassroom() {
        System.out.println("예약 목록:");
        for (Department d : repo.getDepartments()) {
            System.out.println(d.getId() + " " + d.getName() + " " + d.getOffice());
        }
    }
    private static void reserveClassroom (Scanner scanner) {
        System.out.println("학과명: ");
        String name = scanner.nextLine();
        System.out.println("학과 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("에약 원하는 교실: ");
        String office = scanner.nextLine();

        Department reserve = new Department(id, name, office);
        repo.getDepartments().add(reserve);
        System.out.println("예약이 완료되었습니다.");
    }

    private static void updateClassroom(Scanner scanner) {
        System.out.println("예약한 학과 ID를 입력하세요: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Department d: repo.getDepartments()) {
            if (d.getId() == id) {
                System.out.println("새 예약 교실: ");
                String office = scanner.nextLine();

                d.setOffice(office);
                System.out.println("예약 정보가 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 예약을 찾을 수 없습니다.");
    }

    private static void deleteClassroom(Scanner scanner) {
        System.out.println("예약을 취소할 학과의 ID를 입력하세요: ");
        int id  = scanner.nextInt();
        for (int i = 0; i < repo.getDepartments().size(); i++) {
            if (repo.getDepartments().get(i).getId() == id) {
                repo.getDepartments().remove(i);
                System.out.println("예약이 취소되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 예약을 찾을 수 없습니다.");
    }

    private static void takesMenu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("=============================");
            System.out.println("1. 성적 등록");
            System.out.println("2. 성적 조회");
            System.out.println("3. 성적 수정");
            System.out.println("4. 성적 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerGrade(scanner);
                    break;
                case 2:
                    displayGrade();
                    break;
                case 3:
                    updateTakes(scanner);
                    break;
                case 4:
                    deleteTakes(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerGrade(Scanner scanner){
        // 학생 수를 입력 받습니다.
        System.out.println("과목 코드를 입력하세요: ");
        String subject = scanner.nextLine();
        System.out.print("점수를 입력할 학생 수를 입력하세요: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        String score;
        for(int i = 0; i < numStudents; i++){
            System.out.println("학생 id를 입력하세요: ");
            String id = scanner.nextLine();
            System.out.println("해당 학생의 점수를 입력해주세요: ");
            int intScore = scanner.nextInt();
            scanner.nextLine();
            // 점수에 따라 학점 결정
            if (intScore >= 95) {
                score = "A+";
            } else if (intScore >= 90) {
                score = "A";
            } else if (intScore >= 85) {
                score = "B+";
            } else if (intScore >= 80) {
                score = "B";
            } else if (intScore >= 75) {
                score = "C+";
            } else if (intScore >= 70) {
                score = "C";
            } else if (intScore >= 65) {
                score = "D+";
            } else if (intScore >= 60) {
                score = "D";
            } else {
                score = "F";
            }
            System.out.println("과목: " + subject + " 학번: " + id + " 성적: " + score);
            Takes takes = new Takes(id, subject, score);
            repo.getTakes().add(takes);
        }
        System.out.println("점수가 성공적으로 등록되었습니다.");
    }

    private static void displayGrade(){
        System.out.println("등록된 점수 목록");
        for(Takes t : repo.getTakes()){
            System.out.println(t.getId() + " " + t.getSubject() + " " + t.getScore());
        }
    }

    private static void updateTakes(Scanner scanner) {
        System.out.println("수정할 성적의 과목코드를 입력해주세요: ");
        String subject = scanner.nextLine();
        boolean foundSubject = false;   //과목을 찾았는지 판단한 변수

        for (Takes takes : repo.getTakes()) {
            if (takes.getSubject().equals(subject)) {
                foundSubject = true;
                System.out.println("수정할 성적의 학생번호를 입력해주세요: ");
                String id = scanner.nextLine();
                for (Takes t : repo.getTakes()) {
                    if (t.getId().equals(id) && t.getSubject().equals(subject)) {
                        System.out.println("새 성적: ");
                        String score = scanner.nextLine();
                        t.setScore(score);
                        System.out.println("성적이 수정되었습니다.");
                        return;
                    }
                }
                System.out.println(subject + " 과목에 해당 학생번호가 없습니다.");
                return;
            }
        }

        System.out.println("해당 과목코드를 찾을 수 없습니다.");
    }

    private static void deleteTakes(Scanner scanner){
        System.out.println("삭제할 성적의 과목코드를 입력해주세요: ");
        String subject = scanner.nextLine();
        boolean foundSubject = false;   //과목을 찾았는지 판단한 변수

        for (Takes takes : repo.getTakes()) {
            if (takes.getSubject().equals(subject)) {
                foundSubject = true;
                System.out.println("삭제할 성적의 학생번호를 입력해주세요: ");
                String id = scanner.nextLine();
                for (Takes t : repo.getTakes()) {
                    if (t.getId().equals(id) && t.getSubject().equals(subject)) {
                        repo.getTakes().remove(t);
                        System.out.println("성적이 삭제되었습니다.");
                        return;
                    }
                }
                System.out.println(subject + " 과목에 해당 학생번호가 없습니다.");
                return;
            }
        }
        System.out.println("해당 과목코드를 찾을 수 없습니다.");
    }
}   // end of class SchoolManagementEx