import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. SETUP DATABASE BANK
        Bank bankBCA = new Bank();
        bankBCA.addCustomer("Muhammad", "Akbar"); // Menambahkan nasabah
        
        Customer akbar = bankBCA.getCustomer(0);
        akbar.setAccount(new Account(500000.0)); // Memberikan rekening dengan saldo Rp 500.000
        
        Account rekUtama = akbar.getAccount(0);

        // 2. SETUP MESIN ATM
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("==================================");
        System.out.println("  SELAMAT DATANG DI ATM BANK BCA  ");
        System.out.println("==================================");
        System.out.println("Nasabah: " + akbar.getFirstName() + " " + akbar.getLastName());

        // 3. LOOPING MENU ATM
        while (isRunning) {
            System.out.println("\n--- SILAKAN PILIH MENU ---");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda (1/2/3/4): ");
            
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("-> Saldo Anda saat ini: Rp " + rekUtama.getBalance());
                
            } else if (pilihan == 2) {
                System.out.print("Masukkan nominal setor: Rp ");
                double nominalSetor = input.nextDouble();
                
                boolean statusSetor = rekUtama.deposit(nominalSetor);
                if (statusSetor) {
                    System.out.println("-> Setor tunai berhasil! Saldo Anda sekarang: Rp " + rekUtama.getBalance());
                } else {
                    System.out.println("-> Nominal setor harus lebih dari 0.");
                }
                
            } else if (pilihan == 3) {
                System.out.print("Masukkan nominal tarik: Rp ");
                double nominalTarik = input.nextDouble();
                
                boolean statusTarik = rekUtama.withdraw(nominalTarik);
                if (statusTarik) {
                    System.out.println("-> Tarik tunai berhasil! Sisa saldo Anda: Rp " + rekUtama.getBalance());
                } else {
                    System.out.println("-> TRANSAKSI GAGAL: Saldo tidak mencukupi atau nominal tidak valid!");
                }
                
            } else if (pilihan == 4) {
                System.out.println("-> Terima kasih telah menggunakan layanan ATM BCA.");
                isRunning = false; 
            } else {
                System.out.println("-> Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        
        input.close(); 
    }
}